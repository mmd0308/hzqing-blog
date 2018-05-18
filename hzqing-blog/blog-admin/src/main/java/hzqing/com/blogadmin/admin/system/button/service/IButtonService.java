package hzqing.com.blogadmin.admin.system.button.service;

import hzqing.com.blogadmin.admin.system.button.entity.Button;
import hzqing.com.blogadmin.admin.system.button.vo.ButtonVO;
import hzqing.com.blogadmin.base.service.IBaseService;

import java.util.List;

public interface IButtonService extends IBaseService<Button> {
    List<Button> getButtonByMenuIdOrRoleId(ButtonVO buttonVO);
}
