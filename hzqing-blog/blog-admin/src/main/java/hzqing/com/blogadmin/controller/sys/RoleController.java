package hzqing.com.blogadmin.controller.sys;

import hzqing.com.blogadmin.entity.sys.Role;
import hzqing.com.blogadmin.service.sys.IRoleService;
import hzqing.com.hzqingcommon.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/role")
public class RoleController extends BaseController<Role,IRoleService>{
}
