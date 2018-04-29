package hzqing.com.blogadmin.admin.blogger.comments.vo;

import com.github.pagehelper.PageInfo;
import hzqing.com.blogadmin.admin.blogger.comments.entity.Comments;
import hzqing.com.blogadmin.admin.system.user.entity.User;
import org.apache.ibatis.type.Alias;

import java.util.Date;
import java.util.List;

@Alias("commentsvo")
public class CommentsVO extends Comments{

    private String userFullName;

    private List<CommentsVO> lists;


    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public List<CommentsVO> getLists() {
        return lists;
    }

    public void setLists(List<CommentsVO> lists) {
        this.lists = lists;
    }
}
