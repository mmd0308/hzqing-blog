package hzqing.com.blogadmin.controller.sys;

import com.sun.org.apache.regexp.internal.RE;
import hzqing.com.blogadmin.base.controller.BaseController;
import hzqing.com.blogadmin.entity.sys.Menu;
import hzqing.com.blogadmin.service.sys.IMenuService;
import hzqing.com.hzqingcommon.response.ResponseMessage;
import org.hibernate.validator.constraints.ModCheck;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/menu")
public class MenuController extends BaseController<Menu,IMenuService> {
    @GetMapping("/tree/{id}")
    public ResponseMessage<List<Menu>> getTree(@PathVariable String id){
        List<Menu> trees = baseService.getTree(id);
        return new ResponseMessage<>().success(trees);
    }

    /**
     * 根据父级别的id,获取子类下一个levelcode
     * @param parentId
     * @return
     */
    @GetMapping("/getNextLevelCode/{parentId}/{levelCode}")
    public ResponseMessage<String> getNextLevelCode(@PathVariable String parentId,@PathVariable String levelCode){
        String resCode = baseService.getNextLevelCode(parentId,levelCode);
        return  new ResponseMessage<>().success(resCode);
    }
}
