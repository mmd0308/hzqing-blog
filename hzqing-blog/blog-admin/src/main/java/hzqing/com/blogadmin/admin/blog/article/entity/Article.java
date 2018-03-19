package hzqing.com.blogadmin.admin.blog.article.entity;

import org.apache.ibatis.type.Alias;

import java.util.Date;
import java.util.List;

@Alias("article")
public class Article {
    private String id;
    private String userId;
    private String arTitle;
    private String arDesc;
    private String arContent;
    private String arContentHtml;
    private Date arCtime;
    private Date arEtime;
    private String arState;
    private String arUp;



    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", arTitle='" + arTitle + '\'' +
                ", arDesc='" + arDesc + '\'' +
                ", arContent='" + arContent + '\'' +
                ", arContentHtml='" + arContentHtml + '\'' +
                ", arCtime=" + arCtime +
                ", arEtime=" + arEtime +
                ", arState='" + arState + '\'' +
                ", arUp='" + arUp + '\'' +
                '}';
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getArTitle() {
        return arTitle;
    }

    public void setArTitle(String arTitle) {
        this.arTitle = arTitle;
    }

    public String getArDesc() {
        return arDesc;
    }

    public void setArDesc(String arDesc) {
        this.arDesc = arDesc;
    }

    public String getArContent() {
        return arContent;
    }

    public void setArContent(String arContent) {
        this.arContent = arContent;
    }

    public String getArContentHtml() {
        return arContentHtml;
    }

    public void setArContentHtml(String arContentHtml) {
        this.arContentHtml = arContentHtml;
    }

    public Date getArCtime() {
        return arCtime;
    }

    public void setArCtime(Date arCtime) {
        this.arCtime = arCtime;
    }

    public Date getArEtime() {
        return arEtime;
    }

    public void setArEtime(Date arEtime) {
        this.arEtime = arEtime;
    }

    public String getArState() {
        return arState;
    }

    public void setArState(String arState) {
        this.arState = arState;
    }

    public String getArUp() {
        return arUp;
    }

    public void setArUp(String arUp) {
        this.arUp = arUp;
    }


}
