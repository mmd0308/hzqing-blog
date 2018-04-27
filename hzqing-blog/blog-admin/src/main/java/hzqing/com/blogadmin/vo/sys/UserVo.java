package hzqing.com.blogadmin.vo.sys;

import hzqing.com.blogadmin.admin.system.menu.entity.Menu;
import hzqing.com.blogadmin.admin.system.role.entity.Role;
import hzqing.com.blogadmin.admin.system.user.entity.User;

import java.io.Serializable;
import java.util.List;

public class UserVo extends User implements Serializable {


    /**
     * 角色
     */
    private List<Role> roles;
    private List<Menu> menus;
    /**
     * 资源的编码
     */
    private List<String> resCode;

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<String> getResCode() {
        return resCode;
    }

    public void setResCode(List<String> resCode) {
        this.resCode = resCode;
    }
}
