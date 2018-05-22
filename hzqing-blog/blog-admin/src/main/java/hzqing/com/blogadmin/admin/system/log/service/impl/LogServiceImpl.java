package hzqing.com.blogadmin.admin.system.log.service.impl;

import com.github.pagehelper.PageInfo;
import hzqing.com.blogadmin.admin.system.log.entity.Log;
import hzqing.com.blogadmin.admin.system.log.service.ILogService;
import hzqing.com.blogadmin.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class LogServiceImpl extends BaseServiceImpl<Log> implements ILogService {

    public LogServiceImpl() {
        super.mapper = "LogMapper";
    }

}


