package hzqing.com.blogadmin.admin.blogger.comments.service.impl;

import hzqing.com.blogadmin.admin.blogger.comments.entity.Comments;
import hzqing.com.blogadmin.admin.blogger.comments.service.ICommentsService;
import hzqing.com.blogadmin.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CommentsServiceImpl extends BaseServiceImpl<Comments> implements ICommentsService  {
    public CommentsServiceImpl(){
        super.mapper = "CommentsMapper";
    }

}
