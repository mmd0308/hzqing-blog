package hzqing.com.blogadmin.controller.sys;

import hzqing.com.blogadmin.entity.sys.Role;
import hzqing.com.blogadmin.service.sys.IRoleService;
import hzqing.com.hzqingcommon.controller.BaseController;
import hzqing.com.hzqingcommon.response.ResponseMessage;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/admin/role")
public class RoleController extends BaseController<Role,IRoleService>{
    /**
     * 获取所有的启用角色
     * @return
     */
    @GetMapping("/enabled")
    public ResponseMessage<List<Role>> getAllEnabledRole(){
        List<Role> enabledRole = baseService.getAllEnabledRole();
        return new ResponseMessage<List<Role>>().success(enabledRole);
    }

    /**
     * 根据用户id,获取用户角色
     * @param id
     * @return
     */
    @GetMapping("/getRoleByUserId/{id}")
    public ResponseMessage<List<Role>> getRoleByUserId(@PathVariable String id){
        List<Role> roles = baseService.getRoleByUserId(id);
        return new ResponseMessage<>().success(roles);
    }

    /**
     * 角色绑定资源
     * @param resouce
     * @return
     */
    @PostMapping("/addRoleMenu/{roleId}")
    public ResponseMessage<String> addRoleMenu(@RequestBody HashMap<String,Object> resouce){
        baseService.addRoleMenu(resouce);
        return  new ResponseMessage<>().success();
    }
    @GetMapping("/getMenuIdByRoleId/{roleId}")
    public ResponseMessage<List<String>> getMenuIdByRoleId(@PathVariable String roleId){
        List<String> mIds = baseService.getMenuIdByRoleId(roleId);
        return  new ResponseMessage<>().success(mIds);
    }
}
