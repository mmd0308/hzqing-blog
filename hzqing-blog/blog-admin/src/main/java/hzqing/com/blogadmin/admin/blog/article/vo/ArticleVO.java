package hzqing.com.blogadmin.admin.blog.article.vo;

import hzqing.com.blogadmin.admin.blog.article.entity.Article;
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
