package hzqing.com.blogadmin.admin.blogger.comments.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import hzqing.com.blogadmin.admin.blogger.comments.entity.Comments;
import hzqing.com.blogadmin.admin.blogger.comments.service.ICommentsService;
import hzqing.com.blogadmin.admin.blogger.comments.vo.CommentsVO;
import hzqing.com.blogadmin.base.service.impl.BaseServiceImpl;
import hzqing.com.blogadmin.constant.Constant;
import hzqing.com.hzqingcommon.util.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static hzqing.com.blogadmin.constant.Constant.USER_ID;

@Service
public class CommentsServiceImpl extends BaseServiceImpl<Comments> implements ICommentsService  {
    public CommentsServiceImpl(){
        super.mapper = "CommentsMapper";
    }

    @Override
    public int save(Comments comments) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        comments.setUserId((String) request.getAttribute(USER_ID));
        String uuid = UUIDUtils.get32UUID();
        comments.setId(uuid);
        if (null == comments.getSuperId() || comments.getSuperId() == "")
            comments.setSuperId(uuid);
        return super.save(comments);
    }


    @Override
    public PageInfo<CommentsVO> showTree(Integer start, Integer pageSize, CommentsVO comments) {
        if (null == start){
            start = 1;
        }
        if (null == pageSize){
            pageSize = 10;
        }
        PageHelper.startPage(start,pageSize);
        comments.setCoId("-1");
        List<CommentsVO> lists = (List<CommentsVO>) baseDao.findForList(mapper + ".showPage", comments);
        return new PageInfo<>(trees(lists));
    }

    private List<CommentsVO> trees(List<CommentsVO> commentsVOS){
        for (CommentsVO vo :
                commentsVOS) {
            List<CommentsVO> byCoId = findBySuperId(vo.getId());
            if (null != byCoId)
                vo.setLists(byCoId);
        }
        return  commentsVOS;
    }

/*    private List<CommentsVO> findByCoId(String id){
        CommentsVO vo = new CommentsVO();
        vo.setCoId(id);
        List<CommentsVO> list = (List<CommentsVO>) baseDao.findForList(mapper + ".showPage", vo);
        return  list;
    }*/
    private List<CommentsVO> findBySuperId(String superId){
        CommentsVO vo = new CommentsVO();
        vo.setSuperId(superId);
        List<CommentsVO> list = (List<CommentsVO>) baseDao.findForList(mapper + ".showPage", vo);
        return  list;
    }
}
