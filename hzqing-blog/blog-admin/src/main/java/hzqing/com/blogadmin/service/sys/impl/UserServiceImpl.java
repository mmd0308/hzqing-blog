package hzqing.com.blogadmin.service.sys.impl;

import hzqing.com.blogadmin.entity.sys.Role;
import hzqing.com.blogadmin.entity.sys.User;
import hzqing.com.blogadmin.service.sys.IUserService;
import hzqing.com.hzqingcommon.jwt.JwtTokenUtil;
import hzqing.com.hzqingcommon.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
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

    @Override
    @Transactional
    public void saveUserRole(HashMap<String, Object> map) {
        String userId  = map.get("userId").toString();
        ArrayList<HashMap<String,Object>> roles = (ArrayList<HashMap<String, Object>>) map.get("roles");
        List<Map<String,String>> lists = new ArrayList<>();
        for (HashMap r : roles){
            HashMap<String,String> m = new HashMap<>();
            m.put("user_id",userId);
            m.put("role_id", (String) r.get("id"));
            lists.add(m);
        }
        //删除原先的
        baseDao.delete(mapper+".deleteUserRoleByUserId",userId);
        if (lists.size()>0){
            //批量新增新的权限
            baseDao.batchSave(mapper+".batchSave",lists);
        }

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
