package hzqing.com.blogadmin.service.blog;

import hzqing.com.blogadmin.entity.blog.Article;
import hzqing.com.hzqingcommon.service.IBaseService;

import java.util.List;
import java.util.Map;

public interface IArticleService extends IBaseService<Article>{
    void saveOrUpdate(Article article,String token);

    List<String> getCateByAid(String id);
}
