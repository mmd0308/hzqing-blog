package hzqing.com.blogadmin.service.blog.impl;

import hzqing.com.blogadmin.entity.blog.Visit;
import hzqing.com.blogadmin.service.blog.IVisitService;
import hzqing.com.hzqingcommon.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;

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
