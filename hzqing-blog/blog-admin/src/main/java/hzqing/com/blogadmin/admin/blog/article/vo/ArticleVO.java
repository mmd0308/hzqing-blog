package hzqing.com.blogadmin.admin.blog.article.vo;

import hzqing.com.blogadmin.admin.blog.article.entity.Article;
import hzqing.com.blogadmin.admin.blog.tag.entity.Tag;
import hzqing.com.blogadmin.admin.system.user.entity.User;
import org.apache.ibatis.type.Alias;

import java.util.List;
@Alias("articleVO")
public class ArticleVO extends Article{
    /**
     * 分类的ID
     */
    private String tagId;
    /**
     * 标签的id
     */
    private List<String> lables;
    /**
     * 类别
     */
    private Tag tag;
    /**
     * 标签
     */
    private List<Tag> listLables;
    /**
     * 用户全名
     */
    private String fullName;
    /**
     * 文章访问数量
     */
    private String countNum;

    /**
     * 文章列表排序规则
     * UP
     * ETIME
     * UPETIME
     */
    private String arOrder;


    public String getArOrder() {
        return arOrder;
    }

    public void setArOrder(String arOrder) {
        this.arOrder = arOrder;
    }

    public String getCountNum() {
        return countNum;
    }

    public void setCountNum(String countNum) {
        this.countNum = countNum;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public List<Tag> getListLables() {
        return listLables;
    }

    public void setListLables(List<Tag> listLables) {
        this.listLables = listLables;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public List<String> getLables() {
        return lables;
    }

    public void setLables(List<String> lables) {
        this.lables = lables;
    }

    @Override
    public String toString() {
        return "ArticleVO{" +
                "tagId='" + tagId + '\'' +
                ", lables=" + lables +
                '}';
    }
}
