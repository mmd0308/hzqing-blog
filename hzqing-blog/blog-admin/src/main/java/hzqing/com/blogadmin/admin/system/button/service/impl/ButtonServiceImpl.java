package hzqing.com.blogadmin.admin.system.button.service.impl;

import hzqing.com.blogadmin.admin.system.button.entity.Button;
import hzqing.com.blogadmin.admin.system.button.service.IButtonService;
import hzqing.com.blogadmin.admin.system.button.vo.ButtonVO;
import hzqing.com.blogadmin.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

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
