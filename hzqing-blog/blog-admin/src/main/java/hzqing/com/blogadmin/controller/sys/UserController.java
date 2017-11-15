package hzqing.com.blogadmin.controller.sys;

import hzqing.com.blogadmin.entity.sys.Role;
import hzqing.com.blogadmin.entity.sys.User;
import hzqing.com.blogadmin.service.sys.IUserService;
import hzqing.com.blogadmin.vo.sys.UserVo;
import hzqing.com.hzqingcommon.controller.BaseController;
import hzqing.com.hzqingcommon.response.ResponseMessage;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/user")
public class UserController extends BaseController<User,IUserService>{
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
    public ResponseMessage logout(@RequestHeader("access-token") String token,HttpServletRequest request){
        baseService.logout(token);
        request.getSession().invalidate();
        return new ResponseMessage().success();
    }


}
