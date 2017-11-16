package hzqing.com.blogadmin.service.blog.impl;

import hzqing.com.blogadmin.service.blog.IWriteService;
import hzqing.com.hzqingcommon.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class WriteServiceImpl extends BaseServiceImpl<Map> implements IWriteService{
    public WriteServiceImpl() {
        super.mapper="WriteMapper";
    }
}
