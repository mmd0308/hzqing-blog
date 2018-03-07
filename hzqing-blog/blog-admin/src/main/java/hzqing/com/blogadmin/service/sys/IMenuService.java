package hzqing.com.blogadmin.service.sys;

import hzqing.com.blogadmin.base.service.IBaseService;
import hzqing.com.blogadmin.entity.sys.Menu;

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
     * @param roles
     * @return
     */
    List<Menu> getMenusByRids(List<String> roles);

    /**
     * 根据用户id，获取菜单
     * @param id
     * @return
     */
    List<Menu> getMenusByUid(String id);
}
