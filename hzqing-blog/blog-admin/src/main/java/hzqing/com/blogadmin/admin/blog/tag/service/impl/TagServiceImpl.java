package hzqing.com.blogadmin.admin.blog.tag.service.impl;

import hzqing.com.blogadmin.base.service.impl.BaseServiceImpl;
import hzqing.com.blogadmin.admin.blog.tag.entity.Tag;
import hzqing.com.blogadmin.admin.blog.tag.service.ITagService;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl extends BaseServiceImpl<Tag> implements ITagService {
    public TagServiceImpl() {
        super.mapper="TagMapper";
    }
}
