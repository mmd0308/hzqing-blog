package hzqing.com.blogadmin.admin.system.dict.controller;

import hzqing.com.blogadmin.admin.system.dict.entity.Dict;
import hzqing.com.blogadmin.admin.system.dict.service.IDictService;
import hzqing.com.blogadmin.admin.system.dict.vo.DictVO;
import hzqing.com.blogadmin.admin.system.menu.entity.Menu;
import hzqing.com.blogadmin.base.controller.BaseController;
import hzqing.com.blogadmin.utils.ResponseMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dict")
public class DictController extends BaseController<Dict,IDictService> {
    /**
     * 获取数据字典
     * @param id
     * @return
     */
    @GetMapping("/tree/{id}")
    public ResponseMessage<List<DictVO>> getTree(@PathVariable String id){
        List<DictVO> trees = baseService.getTree(id);
        return new ResponseMessage<>().success(trees);
    }
}
