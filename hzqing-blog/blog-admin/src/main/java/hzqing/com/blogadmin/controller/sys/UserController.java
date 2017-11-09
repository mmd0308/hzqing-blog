package hzqing.com.blogadmin.controller.sys;

import hzqing.com.blogadmin.entity.sys.User;
import hzqing.com.blogadmin.service.sys.IUserService;
import hzqing.com.hzqingcommon.controller.BaseController;
import hzqing.com.hzqingcommon.response.ResponseMessage;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/admin/user")
public class UserController extends BaseController<User,IUserService>{
    @PostMapping("/login")
    public ResponseMessage<String> login(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        String token = baseService.login(username,password);
        return  new ResponseMessage().success(token);
    }
    @GetMapping("/getUserinfo")
    public ResponseMessage<User> getUserinfo(String token){
        User user = baseService.getUserinfo(token);
        return  new ResponseMessage<User>().success(user);
    }


}
