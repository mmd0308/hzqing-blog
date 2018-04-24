package hzqing.com.blogadmin.admin.system.button.controller;

import hzqing.com.blogadmin.admin.system.button.entity.Button;
import hzqing.com.blogadmin.admin.system.button.service.IButtonService;
import hzqing.com.blogadmin.base.controller.BaseController;
import hzqing.com.blogadmin.utils.ResponseMessage;
import hzqing.com.blogadmin.vo.sys.UserVo;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/admin/button")
public class ButtonController extends BaseController<Button,IButtonService> {

    @GetMapping("/getButtonByMenuId/{id}")
    public ResponseMessage<List<Button>> getButtonByMenuId(@PathVariable String id) {
        List<Button> buttons = baseService.getButtonByMenuId(id);
        return null;
    }
}
