package hzqing.com.blogadmin.admin.bus.comments.service;

import com.github.pagehelper.PageInfo;
import hzqing.com.blogadmin.admin.bus.comments.entity.Comments;
import hzqing.com.blogadmin.admin.bus.comments.vo.CommentsVO;
import hzqing.com.blogadmin.base.service.IBaseService;

public interface ICommentsService extends IBaseService<Comments> {
    PageInfo<CommentsVO> showTree(Integer page, Integer pageSize, CommentsVO comments);
}
