package hzqing.com.blogadmin.admin.blogger.comments.entity;

import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("comments")
public class Comments {


    private String id;
    private String articleId;
    private String coId;
    private String userId;
    private String coContent;
    private Date coCtime;
    private String superId;
    private String coType;

    public String getCoType() {
        return coType;
    }

    public void setCoType(String coType) {
        this.coType = coType;
    }

    public String getSuperId() {
        return superId;
    }

    public void setSuperId(String superId) {
        this.superId = superId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getCoId() {
        return coId;
    }

    public void setCoId(String coId) {
        this.coId = coId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCoContent() {
        return coContent;
    }

    public void setCoContent(String coContent) {
        this.coContent = coContent;
    }

    public Date getCoCtime() {
        return coCtime;
    }

    public void setCoCtime(Date coCtime) {
        this.coCtime = coCtime;
    }
}
