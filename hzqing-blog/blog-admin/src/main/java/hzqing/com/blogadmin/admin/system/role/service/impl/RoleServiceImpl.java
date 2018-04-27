package hzqing.com.blogadmin.admin.system.role.service.impl;

import hzqing.com.blogadmin.admin.system.menu.entity.Menu;
import hzqing.com.blogadmin.base.service.impl.BaseServiceImpl;
import hzqing.com.blogadmin.admin.system.role.entity.Role;
import hzqing.com.blogadmin.admin.system.role.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService {

    public RoleServiceImpl() {
        super.mapper = "roleMapper";
    }

    @Override
    public List<Role> getAllEnabledRole() {
        Role role = new Role();
        role.setEnabled("1");
        return (List<Role>) baseDao.findForList(mapper+".query",role);
    }

    @Override
    public List<Role> getRoleByUserId(String id) {
        return (List<Role>) baseDao.findForList(mapper+".getRoleByUserId",id);
    }

    @Transactional
    @Override
    public int addRoleRes(HashMap<String, Object> resouce) {
        String roleId = (String) resouce.get("roleId");
        String menuId = (String) resouce.get("menuId");
        String buttons = (String) resouce.get("buttons");

        return addBatchRoleResource(menuId,roleId,"menu") + addBatchRoleResource(buttons,roleId,"button");
    }

    @Override
    public List<String> getResIdByRoleId(String roleId) {
        return (List<String>) baseDao.findForList(mapper+".getResIdByRoleId",roleId);
    }


    /**
     * 根据角色id，资源类型，更新资源
     * @param resource
     * @param roleId
     * @param resType
     * @return
     */
    private int addBatchRoleResource( String resource,String roleId, String resType) {
        //首先删除角色绑定的资源和类型
        HashMap<String,String> params = new HashMap<>();
        params.put("roleId",roleId);
        params.put("resourceType",resType);
        baseDao.delete(mapper+".deleteRoleMenuButtonByRid",params);

        String[] split = resource.split(",");
        List<Map<String,String>> lists = new ArrayList<>();
        for (String s : split) {
            Map<String,String> m = new HashMap();
            m.put("roleId",roleId);
            m.put("resId",s);
            m.put("resType",resType);
            lists.add(m);
        }
        return (int) baseDao.batchSave(mapper+".addBatchRoleMenuButton",lists);
    }
}


