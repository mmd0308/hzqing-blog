package hzqing.com.blogadmin.admin.blogger.comments.controller;

import hzqing.com.blogadmin.admin.blogger.comments.entity.Comments;
import hzqing.com.blogadmin.admin.blogger.comments.service.ICommentsService;
import hzqing.com.blogadmin.base.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/blogger/comments")
public class CommentsController extends BaseController<Comments,ICommentsService>{

}
