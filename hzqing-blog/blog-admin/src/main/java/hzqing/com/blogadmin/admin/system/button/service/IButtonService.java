package hzqing.com.blogadmin.admin.system.button.service;

import hzqing.com.blogadmin.admin.system.button.entity.Button;
import hzqing.com.blogadmin.base.service.IBaseService;
import hzqing.com.blogadmin.vo.sys.UserVo;

import java.util.HashMap;
import java.util.List;

public interface IButtonService extends IBaseService<Button> {
    List<Button> getButtonByMenuId(String id);
}
