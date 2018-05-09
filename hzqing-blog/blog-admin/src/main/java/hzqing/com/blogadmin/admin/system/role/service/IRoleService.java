package hzqing.com.blogadmin.admin.system.role.service;

import hzqing.com.blogadmin.base.service.IBaseService;
import hzqing.com.blogadmin.admin.system.role.entity.Role;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IRoleService extends IBaseService<Role> {
    List<Role> getAllEnabledRole();

    List<Role> getRoleByUserId(String id);

    int addRoleRes(HashMap<String, Object> resouce);

    Map<String,List<String>> getResIdByRoleId(String roleId);

    List<Role> getDefautsRole(String roleType);

}
