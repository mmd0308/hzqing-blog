package hzqing.com.blogadmin.admin.system.role.service;

import hzqing.com.blogadmin.base.service.IBaseService;
import hzqing.com.blogadmin.admin.system.role.entity.Role;

import java.util.HashMap;
import java.util.List;

public interface IRoleService extends IBaseService<Role> {
    List<Role> getAllEnabledRole();

    List<Role> getRoleByUserId(String id);

    int addRoleMenu(HashMap<String, Object> resouce);

    List<String> getMenuIdByRoleId(String roleId);
}