package hzqing.com.blogadmin.admin.system.button.controller;

import hzqing.com.blogadmin.admin.system.button.entity.Button;
import hzqing.com.blogadmin.admin.system.button.service.IButtonService;
import hzqing.com.blogadmin.admin.system.button.vo.ButtonVO;
import hzqing.com.blogadmin.base.controller.BaseController;
import hzqing.com.blogadmin.utils.ResponseMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/button")
public class ButtonController extends BaseController<Button,IButtonService> {

    @GetMapping("/getButtonByMenuIdOrRoleId/{id}")
    public ResponseMessage<List<Button>> getButtonByMenuIdOrRoleId(@PathVariable String id, ButtonVO buttonVO) {
        List<Button> buttons = baseService.getButtonByMenuIdOrRoleId(buttonVO);
        return new ResponseMessage<>().success(buttons);
    }
}
