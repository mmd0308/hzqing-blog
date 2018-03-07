package hzqing.com.blogadmin.service.sys.impl;

import hzqing.com.blogadmin.base.service.impl.BaseServiceImpl;
import hzqing.com.blogadmin.entity.sys.Menu;
import hzqing.com.blogadmin.service.sys.IMenuService;
import hzqing.com.hzqingcommon.util.LevelCodeUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements IMenuService {

    public MenuServiceImpl() {
        super.mapper = "menuMapper";
    }

    @Override
    public List<Menu> getTree(String id) {
        List<Menu> menuByPId = getMenuByPId(id);
        return trees(menuByPId);
    }

    @Override
    public String getNextLevelCode(String parentId,String levelCode) {
        String maxLCodeByPid = getMaxLCodeByPid(parentId);
        return LevelCodeUtil.getNextLevelCode(maxLCodeByPid,levelCode);
    }

    @Override
    public List<Menu> getMenusByRids(List<String> roles) {
        return (List<Menu>) baseDao.findForList(mapper+".getMenusByRids",roles);
    }

    @Override
    public List<Menu> getMenusByUid(String id) {
        return (List<Menu>) baseDao.findForList(mapper+".getMenusByUid",id);
    }

    /**
     * 采用递归组装树
     * @param menus
     * @return
     */
    private List<Menu> trees(List<Menu> menus){
        for (Menu m : menus){
            List<Menu> menuList = getMenuByPId(m.getId());
            m.setMenus(menuList);
            trees(menuList);
        }
        return  menus;
    }

    /**
     * 根据父id获取menu数据
     * @param id
     * @return
     */
    private List<Menu> getMenuByPId(String id){
        return (List<Menu>)baseDao.findForList(mapper+".getMenuByPId",id);
    }

    /**
     * 根据父id获取子集中做大的levelcode
     * @param pId
     * @return
     */
    private String getMaxLCodeByPid(String pId){
        return (String) baseDao.findForObject(mapper+".getMaxLCodeByPid",pId);
    }

    /**
     * 首先查询她有没有子集,如果有不能删除,没有进行删除
     * @param id
     * @return
     */
    @Override
    public int deletedById(String id) {
        List<Menu> menus = this.getMenuByPId(id);
        if (menus.size()>0){
            return 0;
        }else {
            super.deletedById(id);
            return  1;
        }
    }
}


