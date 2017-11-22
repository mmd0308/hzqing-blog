package hzqing.com.blogadmin.service.blog.impl;

import hzqing.com.blogadmin.entity.blog.Article;
import hzqing.com.blogadmin.service.blog.IArticleService;
import hzqing.com.hzqingcommon.service.impl.BaseServiceImpl;
import hzqing.com.hzqingcommon.util.UUIDUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
@Service
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements IArticleService {
    public ArticleServiceImpl() {
        super.mapper="ArticleMapper";
    }


    @Override
    public void saveOrUpdate(Article article) {
        //表示第一次保存
        if (null == article.getId() || article.getId() == ""){
            article.setId(UUIDUtils.get32UUID());
            article.setArCtime(new Date());
            article.setArEtime(new Date());
            this.save(article);
        }else {
            this.update(article);
        }
    }
}
