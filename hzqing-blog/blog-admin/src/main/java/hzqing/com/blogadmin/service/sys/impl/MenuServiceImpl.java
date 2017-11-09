package hzqing.com.blogadmin.service.sys.impl;

import hzqing.com.blogadmin.entity.sys.Menu;
import hzqing.com.blogadmin.service.sys.IMenuService;
import hzqing.com.hzqingcommon.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements IMenuService {

    public MenuServiceImpl() {
        super.mapper = "menuMapper";
    }
}


