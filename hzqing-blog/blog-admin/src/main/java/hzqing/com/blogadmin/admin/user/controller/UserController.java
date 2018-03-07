package hzqing.com.blogadmin.admin.user.controller;

import hzqing.com.blogadmin.admin.user.service.IUserService;
import hzqing.com.blogadmin.base.controller.BaseController;
import hzqing.com.blogadmin.entity.sys.User;
import hzqing.com.blogadmin.vo.sys.UserVo;
import hzqing.com.hzqingcommon.response.ResponseMessage;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@RequestMapping("/admin/user")
public class UserController extends BaseController<User,IUserService> {
    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public ResponseMessage<String> login( String username, String password){
        String token = baseService.login(username,password);
        return  new ResponseMessage().success(token);
    }

    /**
     * 获取用户信息
     * @param token
     * @return
     */
    @GetMapping("/getUserinfo")
    public ResponseMessage<UserVo> getUserinfo(String token){
        UserVo user = baseService.getUserinfo(token);
        return  new ResponseMessage<UserVo>().success(user);
    }

    /**
     * 给用户赋角色
     * @return
     */
    @PostMapping("/saveUserRole")
    public ResponseMessage<String> saveUserRole(@RequestBody HashMap<String,Object> map){
        baseService.saveUserRole(map);
        return new ResponseMessage().success();
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public ResponseMessage logout(@RequestHeader("ACCESS-TOKEN") String token,HttpServletRequest request){
        baseService.logout(token);
        request.getSession().invalidate();
        return new ResponseMessage().success();
    }


}
