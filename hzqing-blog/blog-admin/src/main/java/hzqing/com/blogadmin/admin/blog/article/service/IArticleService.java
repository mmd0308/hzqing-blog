package hzqing.com.blogadmin.admin.blog.article.service;

import com.github.pagehelper.PageInfo;
import hzqing.com.blogadmin.admin.blog.article.vo.ArticleVO;
import hzqing.com.blogadmin.base.service.IBaseService;
import hzqing.com.blogadmin.admin.blog.article.entity.Article;

import java.util.List;

public interface IArticleService extends IBaseService<Article> {

    List<String> getCateByAid(String id);

    PageInfo<Article> getAllByTagId(Integer page, Integer pageSize, String id);

    void saveVo(ArticleVO t);
}
