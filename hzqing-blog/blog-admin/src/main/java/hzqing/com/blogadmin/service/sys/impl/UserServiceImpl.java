package hzqing.com.blogadmin.service.sys.impl;

import hzqing.com.blogadmin.entity.sys.User;
import hzqing.com.blogadmin.service.sys.IUserService;
import hzqing.com.hzqingcommon.service.impl.BaseServiceImpl;

public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService{
    public UserServiceImpl() {
        super.mapper="UserMapper";
    }
}
