package hzqing.com.blogadmin.admin.blog.tag.vo;

import hzqing.com.blogadmin.admin.blog.tag.entity.Tag;
import org.apache.ibatis.type.Alias;

@Alias("tagvo")
public class TagVO extends Tag{

    private String artNumber; //分类下面博客的数量

    public String getArtNumber() {
        return artNumber;
    }

    public void setArtNumber(String artNumber) {
        this.artNumber = artNumber;
    }
}
