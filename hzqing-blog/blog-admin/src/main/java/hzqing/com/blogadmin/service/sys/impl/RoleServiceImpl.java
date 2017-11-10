package hzqing.com.blogadmin.service.sys.impl;

import hzqing.com.blogadmin.entity.sys.Role;
import hzqing.com.blogadmin.service.sys.IRoleService;
import hzqing.com.hzqingcommon.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService {

    public RoleServiceImpl() {
        super.mapper = "roleMapper";
    }

    @Override
    public List<Role> getAllEnabledRole() {
        Role role = new Role();
        role.setEnabled("1");
        return baseDao.findForList(mapper+".query",role);
    }

    @Override
    public List<Role> getRoleByUserId(String id) {
        return baseDao.findForList(mapper+".getRoleByUserId",id);
    }
}


