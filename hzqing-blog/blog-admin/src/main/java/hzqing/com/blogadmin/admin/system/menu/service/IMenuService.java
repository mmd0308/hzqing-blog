package hzqing.com.blogadmin.admin.system.menu.service;

import hzqing.com.blogadmin.admin.system.menu.vo.MenuVO;
import hzqing.com.blogadmin.admin.system.role.entity.Role;
import hzqing.com.blogadmin.base.service.IBaseService;
import hzqing.com.blogadmin.admin.system.menu.entity.Menu;

import java.util.List;
import java.util.Map;

public interface IMenuService extends IBaseService<Menu> {
    /**
     * 根据父id获取tree
     * @param id
     * @return
     */
    List<Menu> getTree(String id);

    /**
     * 根据父级别的id,获取子类下一个levelcode
     * @param parentId
     * @return
     */
    String getNextLevelCode(String parentId,String levelCode);

    /**
     * 根据角色id,获取菜单信息
     * @param role
     * @return
     */
    List<MenuVO> getMenusByRids(Map<String,String> role);

    /**
     * 根据用户id，获取菜单
     * @param id
     * @return
     */
    List<Menu> getMenusByUid(String id);

    List<MenuVO> getDefaultMenus();

    List<MenuVO> getMenusVoTree(MenuVO menuVO);
}
