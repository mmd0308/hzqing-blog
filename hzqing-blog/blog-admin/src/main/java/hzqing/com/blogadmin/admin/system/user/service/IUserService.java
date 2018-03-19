package hzqing.com.blogadmin.admin.system.user.service;

import hzqing.com.blogadmin.base.service.IBaseService;
import hzqing.com.blogadmin.admin.system.user.entity.User;
import hzqing.com.blogadmin.vo.sys.UserVo;

import java.util.HashMap;

public interface IUserService extends IBaseService<User> {
    String login(String username, String password);

    UserVo getUserinfo(String token);

    void saveUserRole(HashMap<String, Object> map);

    void logout(String token);

    User getUserByUName(String username);
}
