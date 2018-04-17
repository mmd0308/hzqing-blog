package hzqing.com.blogadmin.admin.bus.works.service.impl;

import hzqing.com.blogadmin.admin.bus.works.entity.Works;
import hzqing.com.blogadmin.admin.bus.works.service.IWorksService;
import hzqing.com.blogadmin.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class WorksServiceImpl extends BaseServiceImpl<Works> implements IWorksService {
    public WorksServiceImpl() {
        super.mapper="WorksMapper";
    }
}
