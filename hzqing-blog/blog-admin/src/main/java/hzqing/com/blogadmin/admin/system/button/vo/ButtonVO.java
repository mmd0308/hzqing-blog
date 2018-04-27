package hzqing.com.blogadmin.admin.system.button.vo;

import hzqing.com.blogadmin.admin.system.button.entity.Button;
import org.apache.ibatis.type.Alias;

@Alias("buttonvo")
public class ButtonVO extends Button{
    private String roleId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
