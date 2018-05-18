package hzqing.com.blogadmin.admin.system.dict.service.impl;

import hzqing.com.blogadmin.admin.system.dict.entity.Dict;
import hzqing.com.blogadmin.admin.system.dict.service.IDictService;
import hzqing.com.blogadmin.admin.system.dict.vo.DictVO;
import hzqing.com.blogadmin.admin.system.menu.entity.Menu;
import hzqing.com.blogadmin.base.service.impl.BaseServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DictServiceImpl extends BaseServiceImpl<Dict> implements IDictService {

    public DictServiceImpl() {
        super.mapper= "DictMapper";
    }

    @Override
    public int deletedById(String id) {
        Dict dict = new Dict();
        dict.setParentId(id);
        List<Dict> all = this.findAll(dict);
        if (all.size() == 0 ) {
            return super.deletedById(id);
        }
        return 0;
    }

    @Override
    public List<DictVO> getTree(String id) {
        Dict dict = new Dict();
        dict.setEnabled("1");
        List<Dict> dicts = this.findAll(dict);
        List<DictVO> dictVOS = this.listByPId(dicts, id);
        return listToTree(dicts,dictVOS);
    }

    /**
     * 将list页面转成树行结构
     * @param dicts
     * @param dictVOS
     * @return
     */
    private List<DictVO> listToTree(List<Dict> dicts,List<DictVO> dictVOS) {
        for (DictVO vo:dictVOS) {
            List<DictVO> vos = this.listByPId(dicts, vo.getId());
            vo.setChildren(vos);
            this.listToTree(dicts,vos);
        }
        return dictVOS;
    }

    /**
     * 根据父级别id，获取父级别列表
     * @param dicts
     * @param parentId
     * @return
     */
    private List<DictVO> listByPId(List<Dict> dicts,String parentId) {
        List<DictVO> dictVOS = new ArrayList<>();
        for (Dict dict :
                dicts) {
            if (dict.getParentId().equals(parentId)) {
                DictVO dictVO = new DictVO();
                BeanUtils.copyProperties(dict,dictVO);
                dictVOS.add(dictVO);
            }

        }
        return dictVOS;
    }
}
