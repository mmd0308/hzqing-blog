package hzqing.com.blogadmin.admin.system.menu.entity;

import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("menu")
public class Menu {
    private String id;
    private String menuName;
    private String menuCode;
    private String levelcode;
    private String parentId;
    private String href;
    private String component;
    private String icon;
    private String menuType;
    private String note;
    private String enabled;
    private int sort;

    private List<Menu> menus;
    private String parentName;

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getLevelcode() {
        return levelcode;
    }

    public void setLevelcode(String levelcode) {
        this.levelcode = levelcode;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }


    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuCode='" + menuCode + '\'' +
                ", levelcode='" + levelcode + '\'' +
                ", parentId='" + parentId + '\'' +
                ", href='" + href + '\'' +
                ", component='" + component + '\'' +
                ", icon='" + icon + '\'' +
                ", menuType='" + menuType + '\'' +
                ", note='" + note + '\'' +
                ", enabled='" + enabled + '\'' +
                ", menus=" + menus +
                ", parentName='" + parentName + '\'' +
                '}';
    }
}
