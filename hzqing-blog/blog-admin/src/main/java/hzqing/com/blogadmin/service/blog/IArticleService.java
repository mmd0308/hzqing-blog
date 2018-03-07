package hzqing.com.blogadmin.service.blog;

import com.github.pagehelper.PageInfo;
import hzqing.com.blogadmin.base.service.IBaseService;
import hzqing.com.blogadmin.entity.blog.Article;
import hzqing.com.blogadmin.vo.blog.ArticleVO;

import java.util.List;
import java.util.Map;

public interface IArticleService extends IBaseService<Article> {
    void saveOrUpdate(Article article,String token);

    List<String> getCateByAid(String id);

    PageInfo<Article> queryPageByCid(Integer page, Integer pageSize, Article article);

    PageInfo<Article> queryPageIndex(Integer page, Integer pageSize, Article t);
}
