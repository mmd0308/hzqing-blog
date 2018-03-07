package hzqing.com.blogadmin.service.sys.impl;

import hzqing.com.blogadmin.base.service.impl.BaseServiceImpl;
import hzqing.com.blogadmin.entity.sys.Log;
import hzqing.com.blogadmin.service.sys.ILogService;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl extends BaseServiceImpl<Log> implements ILogService {

    public LogServiceImpl() {
        super.mapper = "LogMapper";
    }
}


