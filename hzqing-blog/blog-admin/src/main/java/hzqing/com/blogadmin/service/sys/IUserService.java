package hzqing.com.blogadmin.service.sys;

import hzqing.com.blogadmin.entity.sys.Role;
import hzqing.com.blogadmin.entity.sys.User;
import hzqing.com.hzqingcommon.service.IBaseService;

import java.util.HashMap;
import java.util.List;

public interface IUserService extends IBaseService<User>{
    String login(String username, String password);

    User getUserinfo(String token);

    void saveUserRole(HashMap<String, Object> map);

}