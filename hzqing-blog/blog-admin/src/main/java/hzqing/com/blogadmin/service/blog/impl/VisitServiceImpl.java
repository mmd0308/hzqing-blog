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

}
