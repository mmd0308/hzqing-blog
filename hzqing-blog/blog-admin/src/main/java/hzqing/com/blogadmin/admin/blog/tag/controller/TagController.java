package hzqing.com.blogadmin.admin.blog.tag.controller;

import hzqing.com.blogadmin.base.controller.BaseController;
import hzqing.com.blogadmin.admin.blog.tag.entity.Tag;
import hzqing.com.blogadmin.admin.blog.tag.service.ITagService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/blog/tag")
public class TagController extends BaseController<Tag,ITagService> {
}
