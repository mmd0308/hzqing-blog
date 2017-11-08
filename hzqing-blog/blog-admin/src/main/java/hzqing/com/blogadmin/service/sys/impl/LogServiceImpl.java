package hzqing.com.blogadmin.service.sys.impl;

import hzqing.com.blogadmin.entity.sys.Log;
import hzqing.com.blogadmin.service.sys.ILogService;
import hzqing.com.hzqingcommon.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl extends BaseServiceImpl<Log> implements ILogService {

    public LogServiceImpl() {
        super.mapper = "LogMapper";
    }
}


