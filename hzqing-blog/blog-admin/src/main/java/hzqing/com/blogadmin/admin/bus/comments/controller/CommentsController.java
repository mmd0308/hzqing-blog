package hzqing.com.blogadmin.admin.bus.comments.controller;

import com.github.pagehelper.PageInfo;
import hzqing.com.blogadmin.admin.bus.comments.entity.Comments;
import hzqing.com.blogadmin.admin.bus.comments.service.ICommentsService;
import hzqing.com.blogadmin.admin.bus.comments.vo.CommentsVO;
import hzqing.com.blogadmin.base.controller.BaseController;
import hzqing.com.blogadmin.utils.ResponseMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bus/comments")
public class CommentsController extends BaseController<Comments,ICommentsService>{

    @GetMapping("/show/pageTree")
    public ResponseMessage<PageInfo<CommentsVO>> pageTree(Integer page, Integer pageSize, CommentsVO comments) {
        PageInfo<CommentsVO> res = baseService.showTree(page,pageSize,comments);
        return new ResponseMessage<>().success(res);
    }
}
