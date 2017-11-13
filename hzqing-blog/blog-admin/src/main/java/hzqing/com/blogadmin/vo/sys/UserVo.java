package hzqing.com.blogadmin.vo.sys;

import hzqing.com.blogadmin.entity.sys.Menu;
import hzqing.com.blogadmin.entity.sys.User;

import java.io.Serializable;
import java.util.List;

public class UserVo extends User implements Serializable {



    private List<String> roles;
    private List<Menu> menus;

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
