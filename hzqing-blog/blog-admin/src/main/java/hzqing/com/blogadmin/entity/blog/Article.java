package hzqing.com.blogadmin.entity.blog;

import org.apache.ibatis.type.Alias;

import java.util.Date;
import java.util.List;

@Alias("article")
public class Article {
    private String id;
    private String userId;
    private String arTitle;
    private String arType;
    private String arUrl;
    private String arLabel;
    private String arDesc;
    private String arContent;
    private String arContentHtml;
    private Date arCtime;
    private Date arEtime;
    private String arState;
    private String arUp;
    private String arSupport;
    private String arCarousel;


    private String clickNum;

    private List<String> cateId;
    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", cateId='" + cateId + '\'' +
                ", arTitle='" + arTitle + '\'' +
                ", arType='" + arType + '\'' +
                ", arUrl='" + arUrl + '\'' +
                ", arLabel='" + arLabel + '\'' +
                ", arDesc='" + arDesc + '\'' +
                ", arContent='" + arContent + '\'' +
                ", arContentHtml='" + arContentHtml + '\'' +
                ", arCtime=" + arCtime +
                ", arEtime=" + arEtime +
                ", arState='" + arState + '\'' +
                ", arUp='" + arUp + '\'' +
                ", arSupport='" + arSupport + '\'' +
                '}';
    }

    public String getArCarousel() {
        return arCarousel;
    }

    public void setArCarousel(String arCarousel) {
        this.arCarousel = arCarousel;
    }

    public String getClickNum() {
        return clickNum;
    }

    public void setClickNum(String clickNum) {
        this.clickNum = clickNum;
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

    public List<String> getCateId() {
        return cateId;
    }

    public void setCateId(List<String> cateId) {
        this.cateId = cateId;
    }

    public String getArTitle() {
        return arTitle;
    }

    public void setArTitle(String arTitle) {
        this.arTitle = arTitle;
    }

    public String getArType() {
        return arType;
    }

    public void setArType(String arType) {
        this.arType = arType;
    }

    public String getArUrl() {
        return arUrl;
    }

    public void setArUrl(String arUrl) {
        this.arUrl = arUrl;
    }

    public String getArLabel() {
        return arLabel;
    }

    public void setArLabel(String arLabel) {
        this.arLabel = arLabel;
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

    public String getArSupport() {
        return arSupport;
    }

    public void setArSupport(String arSupport) {
        this.arSupport = arSupport;
    }
}
