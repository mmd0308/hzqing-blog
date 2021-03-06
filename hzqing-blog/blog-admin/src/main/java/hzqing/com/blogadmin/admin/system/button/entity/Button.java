package hzqing.com.blogadmin.admin.system.button.entity;

import org.apache.ibatis.type.Alias;

@Alias("button")
public class Button {
    private String id;
    private String code;
    private String name;
    private String menuId;
    private String enabled;
    private String path;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Button{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", menuId='" + menuId + '\'' +
                ", enabled='" + enabled + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
