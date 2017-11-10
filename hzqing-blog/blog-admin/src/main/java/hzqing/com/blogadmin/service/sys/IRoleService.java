package hzqing.com.blogadmin.service.sys;

import hzqing.com.blogadmin.entity.sys.Role;
import hzqing.com.hzqingcommon.service.IBaseService;

import java.util.List;

public interface IRoleService extends IBaseService<Role> {
    List<Role> getAllEnabledRole();

    List<Role> getRoleByUserId(String id);
}
