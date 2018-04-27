package hzqing.com.blogadmin.admin.system.button.service.impl;

import hzqing.com.blogadmin.admin.system.button.entity.Button;
import hzqing.com.blogadmin.admin.system.button.service.IButtonService;
import hzqing.com.blogadmin.admin.system.button.vo.ButtonVO;
import hzqing.com.blogadmin.admin.system.menu.entity.Menu;
import hzqing.com.blogadmin.admin.system.menu.service.IMenuService;
import hzqing.com.blogadmin.base.service.impl.BaseServiceImpl;
import hzqing.com.blogadmin.constant.Constant;
import hzqing.com.blogadmin.vo.sys.UserVo;
import hzqing.com.hzqingcommon.jwt.JwtTokenUtil;
import hzqing.com.hzqingcommon.util.AESUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.*;

@Service
public class ButtonServiceImpl extends BaseServiceImpl<Button> implements IButtonService {

    public ButtonServiceImpl() {
        super.mapper= "ButtonMapper";
    }

    @Override
    public List<Button> getButtonByMenuIdOrRoleId(ButtonVO buttonVO) {
        return (List<Button>) baseDao.findForList(mapper+".getButtonByMenuIdOrRoleId",buttonVO);
    }
}
