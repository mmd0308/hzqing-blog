package hzqing.com.blogadmin.admin.blogger.comments.vo;

import com.github.pagehelper.PageInfo;
import hzqing.com.blogadmin.admin.blogger.comments.entity.Comments;
import hzqing.com.blogadmin.admin.system.user.entity.User;
import org.apache.ibatis.type.Alias;

import java.util.Date;
import java.util.List;

@Alias("commentsvo")
public class CommentsVO extends Comments{

    private String userNickName;
    /**
     * 用户头像
     */
    private String avatar;

    private List<CommentsVO> lists;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public List<CommentsVO> getLists() {
        return lists;
    }

    public void setLists(List<CommentsVO> lists) {
        this.lists = lists;
    }
}
