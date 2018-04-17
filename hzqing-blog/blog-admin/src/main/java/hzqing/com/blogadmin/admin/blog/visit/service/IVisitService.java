package hzqing.com.blogadmin.admin.blog.visit.service;

import hzqing.com.blogadmin.base.service.IBaseService;
import hzqing.com.blogadmin.admin.blog.visit.entity.Visit;


public interface IVisitService extends IBaseService<Visit> {

    int getVisitNum();

    int getVisitNumByAId(String id);

    int getSupportNumByAId(String id);
}
