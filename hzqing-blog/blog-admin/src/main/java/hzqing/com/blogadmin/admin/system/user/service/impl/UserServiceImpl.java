package hzqing.com.blogadmin.admin.system.user.service.impl;

import hzqing.com.blogadmin.admin.system.role.entity.Role;
import hzqing.com.blogadmin.admin.system.role.service.IRoleService;
import hzqing.com.blogadmin.admin.system.user.service.IUserService;
import hzqing.com.blogadmin.base.service.impl.BaseServiceImpl;
import hzqing.com.blogadmin.constant.Constant;
import hzqing.com.blogadmin.admin.system.menu.entity.Menu;
import hzqing.com.blogadmin.admin.system.user.entity.User;
import hzqing.com.blogadmin.admin.system.menu.service.IMenuService;
import hzqing.com.blogadmin.vo.sys.UserVo;
import hzqing.com.hzqingcommon.jwt.JwtTokenUtil;
import hzqing.com.hzqingcommon.util.AESUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.*;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {
    @Autowired
    private IMenuService menuService;
    @Autowired
    private IRoleService roleService;

    public UserServiceImpl() {
        super.mapper="UserMapper";
    }


    public String login(String username,String password){
        User user = new User();
        // 支持手机号和邮箱登录
        if (username.indexOf("@") != -1){ // 邮箱登录
            user.setEmail(username);
        } else {
            user.setPhone(username);
        }
        user = this.getLoginUser(user);
        if (user.getId() == null || user.getId() == "") {
            return null;
        }
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        String token = null;
        if (user.getPassword().equals(password)) {
            //生成jwt
            Map<String, Object> claims = new HashMap<String, Object>();  // Claims包含您想要签署的任何信息
            String iss = AESUtil.AESEncode(Constant.AES_SECRET,user.getId()+","+user.getNickName()+","+user.getPassword());
            claims.put("iss",iss); //jwt的签发者 保存用户的帐号和密码以及id 使用AES对称加密
            claims.put("sub",user.getNickName()); // JWT所面向的用户 用户的昵称
            claims.put("iat", new Date());
            claims.put("jti",UUID.randomUUID()); //jwt的唯一身份表示
            //获取token
            token = JwtTokenUtil.generateToken(claims, Constant.JWT_SECRET, Constant.JWT_EXPIRATION);
        }
        return token;
    }

    /**
     * 根据条件查询用户
     * @param user
     * @return
     */
    private User getLoginUser(User user) {
        return (User) baseDao.findForObject(mapper + ".getLoginUser", user);
    }

    /**
     * 根据token获取用户信息
     * @param userId
     * @return
     */
    @Override
    public UserVo getUserinfo(String userId) {
        User user = this.getById(userId);
        UserVo uservo = new UserVo();
        BeanUtils.copyProperties(user,uservo);
        // 根据用户的id获取角色
        List<Role> rols = roleService.getRoleByUserId(userId);
        // 获取系统默认角色
        List<Role> defaults = roleService.getDefautsRole();
        rols.addAll(defaults);
        //设置用户的角色
        uservo.setRoles(rols);
        StringBuffer buffer = new StringBuffer();
        rols.forEach(role -> {
            buffer.append(role.getId());
            buffer.append(",");
        });
        String roleIds = buffer.toString().substring(0,buffer.toString().length()-1);

        //TODO 设置菜单 根据角色id获取菜单
        //List<Menu> menus = menuService.getMenusByUid(uservo.getId());
        //uservo.setMenus(menus);

        // 设置所有的按钮资源编码根据角色id
        uservo.setResCode(this.getResCodeByRoleIds(roleIds));

        return uservo;
    }

    /**
     * 根据角色id，获取按钮资源编码
     * @param ids
     * @return
     */
    private List<String> getResCodeByRoleIds(String ids){
        return (List<String>) baseDao.findForList(mapper+".getResCodeByRoleIds",ids);
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
        String username = JwtTokenUtil.getUsernameFromToken(token,Constant.JWT_SECRET);
    }

    @Override
    public int save(User user) {
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        return super.save(user);
    }


}
