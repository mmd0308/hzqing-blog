package hzqing.com.blogadmin.controller.sys;

import hzqing.com.blogadmin.entity.sys.Menu;
import hzqing.com.blogadmin.service.sys.IMenuService;
import hzqing.com.hzqingcommon.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/menu")
public class MenuController extends BaseController<Menu,IMenuService>{
}
