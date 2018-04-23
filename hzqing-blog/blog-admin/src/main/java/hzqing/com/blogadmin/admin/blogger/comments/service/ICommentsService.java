package hzqing.com.blogadmin.admin.blogger.comments.service;

import com.github.pagehelper.PageInfo;
import hzqing.com.blogadmin.admin.blogger.comments.entity.Comments;
import hzqing.com.blogadmin.admin.blogger.comments.vo.CommentsVO;
import hzqing.com.blogadmin.base.service.IBaseService;

public interface ICommentsService extends IBaseService<Comments> {
    PageInfo<CommentsVO> showTree(Integer page, Integer pageSize, CommentsVO comments);
}
