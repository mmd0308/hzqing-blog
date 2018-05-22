package hzqing.com.blogadmin.admin.system.menu.vo;

import hzqing.com.blogadmin.admin.system.menu.entity.Menu;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("menuvo")
public class MenuVO extends Menu{

    private List<MenuVO> children;

    private String parentName;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<MenuVO> getChildren() {
        return children;
    }

    public void setChildren(List<MenuVO> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "MenuVO{" +
                "children=" + children +
                '}';
    }
}
