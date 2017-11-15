package hzqing.com.blogadmin.service.sys.impl;

import hzqing.com.blogadmin.entity.sys.Menu;
import hzqing.com.blogadmin.entity.sys.Role;
import hzqing.com.blogadmin.entity.sys.User;
import hzqing.com.blogadmin.service.sys.IMenuService;
import hzqing.com.blogadmin.service.sys.IRoleService;
import hzqing.com.blogadmin.service.sys.IUserService;
import hzqing.com.blogadmin.vo.sys.UserVo;
import hzqing.com.hzqingcommon.jwt.JwtTokenUtil;
import hzqing.com.hzqingcommon.service.impl.BaseServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService{
    @Autowired
    private IMenuService menuService;

    @Autowired
    private RedisTemplate redisTemplate;

    private String secret = "hzqing";
    private Integer expiration = 72000;


    public UserServiceImpl() {
        super.mapper="UserMapper";
    }
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";


    public String login(String username,String password){
        User user = (User) baseDao.findForObject(mapper + ".getUserByUName", username);
        if (null != user){
            if (password.equals(user.getPassword())){ //判断密码是否正确
                Object old = redisTemplate.opsForValue().get(user.getUsername());
                String token = "";
                if (old == null) {
                    Map<String, Object> claims = new HashMap<String, Object>();
                    claims.put(CLAIM_KEY_USERNAME, user.getUsername());
                    claims.put(CLAIM_KEY_CREATED, new Date());
                    //获取tocken
                    token = JwtTokenUtil.generateToken(claims,secret,expiration);
                    //key username value tocken 存储在redis中
                    redisTemplate.opsForValue().set(user.getUsername(), token, expiration, TimeUnit.SECONDS);
                } else {
                    token = old.toString();
                }
                return token;
            }
        }
        return  null;

    }

    @Override
    public UserVo getUserinfo(String token) {
        String username = JwtTokenUtil.getUsernameFromToken(token,secret);
        if (username == null)
            return null;
        User user = this.getUserByUName(username);
        UserVo uservo = new UserVo();
        BeanUtils.copyProperties(user,uservo);
        //设置用户的角色
        uservo.setRoles(this.getRoleCodeByUid(uservo.getId()));
        //设置菜单 根据角色id获取菜单
        List<Menu> menus = menuService.getMenusByUid(uservo.getId());
        uservo.setMenus(menus);
        return uservo;
    }

    /**
     * 根据用户id,获取角色的id
     * @param id
     * @return
     */
    private List<String> getRoleCodeByUid(String id){
        return (List<String>) baseDao.findForList(mapper+".getRoleCodeByUid",id);
    }

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    private User getUserByUName(String username){
        return (User) baseDao.findForObject(mapper+".getUserByUName",username);
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

    @Override
    public void logout(String token) {
        String username = JwtTokenUtil.getUsernameFromToken(token,secret);
        System.out.println("logout ........... "+username);
        redisTemplate.opsForValue().set(username,null);
    }


}
