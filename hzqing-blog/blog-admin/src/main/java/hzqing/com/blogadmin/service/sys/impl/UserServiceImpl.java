package hzqing.com.blogadmin.service.sys.impl;

import hzqing.com.blogadmin.entity.sys.User;
import hzqing.com.blogadmin.service.sys.IUserService;
import hzqing.com.hzqingcommon.jwt.JwtTokenUtil;
import hzqing.com.hzqingcommon.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService{
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private String secret = "hzqing";
    private Integer expiration = 7200;


    public UserServiceImpl() {
        super.mapper="UserMapper";
    }
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";


    public String login(String username,String password){
        HashMap<String,Object> map = new HashMap<>();
        map.put("username","admin");
        map.put("password","admin");
        return  generateToken(map);
    }

    @Override
    public User getUserinfo(String token) {
        String username = JwtTokenUtil.getUsernameFromToken(token,secret);
        if (username == null)
            return null;
        User user = new User();
        user.setUsername(username);
        System.out.println("........"+user);
        return user;
    }

    /**
     * 获取token  并将信息存储在redis中
     * @param info
     * @return
     */
    public String generateToken(Map<String,Object> info) {
        Object old = redisTemplate.opsForValue().get(info.get("username"));
        String token = "";
        if (old == null) {
            Map<String, Object> claims = new HashMap<String, Object>();
            claims.put(CLAIM_KEY_USERNAME, info.get("username").toString());
            claims.put(CLAIM_KEY_CREATED, new Date());
            token = JwtTokenUtil.generateToken(claims,secret,expiration);
            redisTemplate.opsForValue().set(info.get("username").toString(), token, expiration, TimeUnit.SECONDS);
        } else {
            token = old.toString();
        }
        return token;
    }
}
