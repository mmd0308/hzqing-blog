package hzqing.com.blogadmin.admin.blog.visit.entity;

import org.apache.ibatis.type.Alias;

import java.util.Date;
@Alias("visit")
public class Visit {
    private String id;
    private Date vTime;
    private String vIp;
    private String userId;
    private int vClicks;
    private int vSupport;
    private String articleId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getvTime() {
        return vTime;
    }

    public void setvTime(Date vTime) {
        this.vTime = vTime;
    }

    public String getvIp() {
        return vIp;
    }

    public void setvIp(String vIp) {
        this.vIp = vIp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getvClicks() {
        return vClicks;
    }

    public void setvClicks(int vClicks) {
        this.vClicks = vClicks;
    }

    public int getvSupport() {
        return vSupport;
    }

    public void setvSupport(int vSupport) {
        this.vSupport = vSupport;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }
}
