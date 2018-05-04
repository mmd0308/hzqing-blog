package hzqing.com.blogadmin.admin.system.menu.vo;

import hzqing.com.blogadmin.admin.system.menu.entity.Menu;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("menuvo")
public class MenuVO extends Menu{

    private List<MenuVO> menusvo;

    public List<MenuVO> getMenusvo() {
        return menusvo;
    }

    public void setMenusvo(List<MenuVO> menusvo) {
        this.menusvo = menusvo;
    }
}
