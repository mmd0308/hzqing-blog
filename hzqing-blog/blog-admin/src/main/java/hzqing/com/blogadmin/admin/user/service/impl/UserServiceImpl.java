package hzqing.com.blogadmin.admin.user.service.impl;

import hzqing.com.blogadmin.admin.user.service.IUserService;
import hzqing.com.blogadmin.base.service.impl.BaseServiceImpl;
import hzqing.com.blogadmin.entity.sys.Menu;
import hzqing.com.blogadmin.entity.sys.User;
import hzqing.com.blogadmin.service.sys.IMenuService;
import hzqing.com.blogadmin.vo.sys.UserVo;
import hzqing.com.hzqingcommon.jwt.JwtTokenUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {
    @Autowired
    private IMenuService menuService;

    @Autowired
    private RedisTemplate redisTemplate;
    
    @Value("${admin.jwt.secret}")
    private String secret;
    @Value("${admin.jwt.expiration}")
    private Integer expiration;

    public UserServiceImpl() {
        super.mapper="UserMapper";
    }


    public String login(String username,String password){
        // 密码加密
        User user = (User) baseDao.findForObject(mapper + ".getUserByUName", username);
        Map<String, Object> claims = new HashMap<String, Object>();  // Claims包含您想要签署的任何信息
        claims.put("sub", "admin");
        claims.put("created", new Date());
        //获取tocken
        String token = JwtTokenUtil.generateToken(claims,secret,expiration);
        return token;
    }

    /**
     * 根据token获取用户信息
     * @param token
     * @return
     */
    @Override
    public UserVo getUserinfo(String token) {
       /* String username = JwtTokenUtil.getUsernameFromToken(token,secret);
        if (username == null)
            return null;*/
        User user = this.getUserByUName("admin");
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
    @Override
    public User getUserByUName(String username){
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
        redisTemplate.opsForValue().set(username,null);
    }

    @Override
    public int save(User user) {
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        return super.save(user);
    }


}
