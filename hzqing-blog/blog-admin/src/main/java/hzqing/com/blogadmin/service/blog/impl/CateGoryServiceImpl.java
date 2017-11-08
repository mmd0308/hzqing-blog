package hzqing.com.blogadmin.service.blog.impl;

import hzqing.com.blogadmin.entity.blog.CateGory;
import hzqing.com.blogadmin.service.blog.ICateGoryService;
import hzqing.com.hzqingcommon.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CateGoryServiceImpl extends BaseServiceImpl<CateGory> implements ICateGoryService {
    public CateGoryServiceImpl() {
        super.mapper="CateGoryMapper";
    }
}
