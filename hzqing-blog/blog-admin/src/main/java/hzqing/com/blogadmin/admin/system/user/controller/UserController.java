package hzqing.com.blogadmin.admin.system.user.controller;

import hzqing.com.blogadmin.admin.system.user.service.IUserService;
import hzqing.com.blogadmin.base.controller.BaseController;
import hzqing.com.blogadmin.admin.system.user.entity.User;
import hzqing.com.blogadmin.constant.Constant;
import hzqing.com.blogadmin.vo.sys.UserVo;
import hzqing.com.blogadmin.utils.ResponseMessage;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@RequestMapping("/admin/user")
public class UserController extends BaseController<User,IUserService> {

    @PostMapping("/show/register")
    public ResponseMessage<Integer> register(@RequestBody User t){
        return  new ResponseMessage<Integer>().success(baseService.save(t));
    }

    @GetMapping("/getUserById")
    public ResponseMessage<User> get(HttpServletRequest request){
        String id = (String) request.getAttribute(Constant.USER_ID);
        User user = baseService.getById(id);
        return new ResponseMessage<User>().success(user);
    }

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public ResponseMessage<String> login(String username, String password){
        String token = baseService.login(username,password);
        if (null == token){
            return new ResponseMessage<>().loginError("登录名或者密码错误");
        }else {
            ResponseMessage message = new ResponseMessage().success(token);
            return message;
        }
    }



    /**
     * 获取用户的信心，根据用户id
     * @param request
     * @return
     */
    @GetMapping("/getUserinfo")
    public ResponseMessage<UserVo> getUserinfo(HttpServletRequest request){
        String userId = (String) request.getAttribute(Constant.USER_ID);
        UserVo user = baseService.getUserinfo(userId);
        return  new ResponseMessage<UserVo>().success(user);
    }
    /**
     * 给用户赋角色
     * @return
     */
    @PostMapping("/saveUserRole")
    public ResponseMessage<String> saveUserRole(@RequestBody HashMap<String,Object> map){
        baseService.saveUserRole(map);
        return new ResponseMessage().success("success");
    }
    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public ResponseMessage logout(@RequestHeader("ACCESS-TOKEN") String token,HttpServletRequest request){
        baseService.logout(token);
        return new ResponseMessage().success("success");
    }
}
