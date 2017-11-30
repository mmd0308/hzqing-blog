package hzqing.com.blogadmin.vo.blog;

import hzqing.com.blogadmin.entity.blog.Article;

public class ArticleVO extends Article{
    private String clickNum;
    private String supNum;

    public String getClickNum() {
        return clickNum;
    }

    public void setClickNum(String clickNum) {
        this.clickNum = clickNum;
    }

    public String getSupNum() {
        return supNum;
    }

    public void setSupNum(String supNum) {
        this.supNum = supNum;
    }
}
