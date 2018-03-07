package hzqing.com.blogadmin.service.blog.impl;

import hzqing.com.blogadmin.base.service.impl.BaseServiceImpl;
import hzqing.com.blogadmin.entity.blog.CateGory;
import hzqing.com.blogadmin.service.blog.ICateGoryService;
import org.springframework.stereotype.Service;

@Service
public class CateGoryServiceImpl extends BaseServiceImpl<CateGory> implements ICateGoryService {
    public CateGoryServiceImpl() {
        super.mapper="CateGoryMapper";
    }
}
