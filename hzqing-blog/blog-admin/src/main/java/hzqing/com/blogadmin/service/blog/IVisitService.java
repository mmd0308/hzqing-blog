package hzqing.com.blogadmin.service.blog;

import hzqing.com.blogadmin.base.service.IBaseService;
import hzqing.com.blogadmin.entity.blog.Visit;


public interface IVisitService extends IBaseService<Visit> {

    int getVisitNum();

    int getVisitNumByAId(String id);

    int getSupportNumByAId(String id);
}
