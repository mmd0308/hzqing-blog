package hzqing.com.blogadmin.admin.system.role.service.impl;

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
    public int addRoleMenu(HashMap<String, Object> resouce) {
        String roleId = (String) resouce.get("roleId");
        String menuId = (String) resouce.get("menuId");
        List<Map<String,String>> lists = new ArrayList<>();
        String[] split = menuId.split(",");
        for (String s : split) {
            Map<String,String> m = new HashMap();
            m.put("roleId",roleId);
            m.put("resId",s);
            m.put("resType","menu");
            lists.add(m);
        }
        //首先删除角色绑定的菜单
        baseDao.delete(mapper+".deleteRoleMenuByRid",roleId);

        return (int) baseDao.batchSave(mapper+".addBatchRoleMenu",lists);
    }

    @Override
    public List<String> getMenuIdByRoleId(String roleId) {
        return (List<String>) baseDao.findForList(mapper+".getMenuIdByRoleId",roleId);
    }
}


