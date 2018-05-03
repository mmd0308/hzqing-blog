package hzqing.com.blogadmin.admin.blog.tag.controller;

import hzqing.com.blogadmin.base.controller.BaseController;
import hzqing.com.blogadmin.admin.blog.tag.entity.Tag;
import hzqing.com.blogadmin.admin.blog.tag.service.ITagService;
import hzqing.com.blogadmin.utils.ResponseMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/blog/tag")
public class TagController extends BaseController<Tag,ITagService> {
    @GetMapping("/show/all")
    public ResponseMessage<List<Tag>> showAll(Tag t){
        return new ResponseMessage<List<Tag>>().success(baseService.findAll(t));
    }

}
