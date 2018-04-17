package hzqing.com.blogadmin.admin.bus.link.service.impl;

import hzqing.com.blogadmin.admin.bus.link.entity.Link;
import hzqing.com.blogadmin.admin.bus.link.service.ILinkService;
import hzqing.com.blogadmin.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkServiceImpl extends BaseServiceImpl<Link> implements ILinkService {
    public LinkServiceImpl() {
        super.mapper="LinkMapper";
    }
}
