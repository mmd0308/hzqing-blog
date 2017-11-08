package hzqing.com.blogadmin.entity.blog;

import org.apache.ibatis.type.Alias;

@Alias("category")
public class CateGory {

    private String id;
    private String cateName;
    private String cateShow;
    private int sort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCateShow() {
        return cateShow;
    }

    public void setCateShow(String cateShow) {
        this.cateShow = cateShow;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
