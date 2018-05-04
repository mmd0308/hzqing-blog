package hzqing.com.blogadmin.admin.system.menu.service.impl;

import hzqing.com.blogadmin.admin.system.menu.service.IMenuService;
import hzqing.com.blogadmin.admin.system.menu.vo.MenuVO;
import hzqing.com.blogadmin.admin.system.role.entity.Role;
import hzqing.com.blogadmin.admin.system.role.service.IRoleService;
import hzqing.com.blogadmin.base.service.impl.BaseServiceImpl;
import hzqing.com.blogadmin.admin.system.menu.entity.Menu;
import hzqing.com.hzqingcommon.util.LevelCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements IMenuService {

    public MenuServiceImpl() {
        super.mapper = "menuMapper";
    }
    @Autowired
    private IRoleService roleService;

    @Override
    public List<Menu> getTree(String id) {
        List<Menu> menuByPId = getMenuByPId(id);
        return trees(menuByPId);
    }

    @Override
    public String getNextLevelCode(String parentId,String levelCode) {
        String maxLCodeByPid = getMaxLCodeByPid(parentId);
        return LevelCodeUtil.getNextLevelCode(maxLCodeByPid,levelCode);
    }



    @Override
    public List<MenuVO> getMenusByRids(Map<String,String> map) {
        List<MenuVO> res = (List<MenuVO>) baseDao.findForList(mapper+".getMenusByRids",map);
        res = listToTree(res);
        return res;
    }

    @Override
    public List<Menu> getMenusByUid(String id) {
        return (List<Menu>) baseDao.findForList(mapper+".getMenusByUid",id);
    }

    @Override
    public List<MenuVO> getDefaultMenus() {
        MenuVO menuVO = new MenuVO();
        menuVO.setMenuType("NL");
        return this.getMenusVoTree(menuVO);
    }

    @Override
    public List<MenuVO> getMenusVoTree(MenuVO menuVO) {
        List<MenuVO> res = (List<MenuVO>) baseDao.findForList(mapper+".queryMenuvo",menuVO);
        res = listToTree(res);
        return res;
    }

    /**
     * 采用递归组装树
     * @param menus
     * @return
     */
    private List<Menu> trees(List<Menu> menus){
        for (Menu m : menus){
            List<Menu> menuList = getMenuByPId(m.getId());
            m.setMenus(menuList);
            trees(menuList);
        }
        return  menus;
    }

    /**
     * 根据父id获取menu数据
     * @param id
     * @return
     */
    private List<Menu> getMenuByPId(String id){
        return (List<Menu>)baseDao.findForList(mapper+".getMenuByPId",id);
    }

    /**
     * 根据父id获取子集中做大的levelcode
     * @param pId
     * @return
     */
    private String getMaxLCodeByPid(String pId){
        return (String) baseDao.findForObject(mapper+".getMaxLCodeByPid",pId);
    }

    /**
     * 首先查询她有没有子集,如果有不能删除,没有进行删除
     * @param id
     * @return
     */
    @Override
    public int deletedById(String id) {
        List<Menu> menus = this.getMenuByPId(id);
        if (menus.size()>0){
            return 0;
        }else {
            super.deletedById(id);
            return  1;
        }
    }

    /**
     * 根据列表转成树形结构
     * @param list
     * @return
     */
    private List<MenuVO> listToTree(List<MenuVO> list){
        List<MenuVO> res = new ArrayList<>();
        int length = getMinLenthLevelCode(list); // 获取顶层菜单的levelcode长度
        if (length == 0){
            return null;
        }
        for (MenuVO menuvo : list) {
            if (menuvo.getLevelcode().length() == length)
            res.add(menuvo);
        }
        for (MenuVO menuVO: res) {
            for (MenuVO m: list) {
                if (menuVO.getId() != null && menuVO.getId().equals(m.getParentId())){
                    if (menuVO.getMenusvo() == null){
                        menuVO.setMenusvo(new ArrayList<MenuVO>());
                    }
                    menuVO.getMenusvo().add(m);
                }
            }
        }
        return  res;
    }

    /**
     * 获取最高层级编码
     * @param list
     * @return
     */
    private int getMinLenthLevelCode(List<MenuVO> list){
        int res = 0;
        for (MenuVO menuVO: list){
            int length = menuVO.getLevelcode().length();
            if (res == 0){
                res = length;
            }else if (length < res) {
                res = length;
            }
        }
        return res;
    }
}


