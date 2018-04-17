package hzqing.com.blogadmin.admin.blog.visit.service.impl;

import hzqing.com.blogadmin.base.service.impl.BaseServiceImpl;
import hzqing.com.blogadmin.admin.blog.visit.entity.Visit;
import hzqing.com.blogadmin.admin.blog.visit.service.IVisitService;
import org.springframework.stereotype.Service;

@Service
public class VisitServiceImpl extends BaseServiceImpl<Visit> implements IVisitService {
    public VisitServiceImpl() {
        super.mapper="VisitMapper";
    }

    @Override
    public int getVisitNum() {
        return (int) baseDao.findForObject(mapper+".getVisitNum",null);
    }

    @Override
    public int getVisitNumByAId(String id) {
        return (int) baseDao.findForObject(mapper+".getVisitNumByAId",id);
    }

    @Override
    public int getSupportNumByAId(String id) {
        return (int) baseDao.findForObject(mapper+".getSupportNumByAId",id);
    }

}
