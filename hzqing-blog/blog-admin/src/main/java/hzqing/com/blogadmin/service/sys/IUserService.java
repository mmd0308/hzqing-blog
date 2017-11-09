package hzqing.com.blogadmin.service.sys;

import hzqing.com.blogadmin.entity.sys.User;
import hzqing.com.hzqingcommon.service.IBaseService;

public interface IUserService extends IBaseService<User>{
    String login(String username, String password);

    User getUserinfo(String token);
}
