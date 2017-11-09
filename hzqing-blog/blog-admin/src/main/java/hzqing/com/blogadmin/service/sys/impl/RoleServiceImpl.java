package hzqing.com.blogadmin.service.sys.impl;

import hzqing.com.blogadmin.entity.sys.Role;
import hzqing.com.blogadmin.service.sys.IRoleService;
import hzqing.com.hzqingcommon.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService {

    public RoleServiceImpl() {
        super.mapper = "roleMapper";
    }
}


