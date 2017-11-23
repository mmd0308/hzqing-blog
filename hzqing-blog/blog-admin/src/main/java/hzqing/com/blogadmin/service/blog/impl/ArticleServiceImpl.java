package hzqing.com.blogadmin.service.blog.impl;

import hzqing.com.blogadmin.entity.blog.Article;
import hzqing.com.blogadmin.entity.sys.User;
import hzqing.com.blogadmin.service.blog.IArticleService;
import hzqing.com.blogadmin.service.sys.IUserService;
import hzqing.com.hzqingcommon.jwt.JwtTokenUtil;
import hzqing.com.hzqingcommon.service.impl.BaseServiceImpl;
import hzqing.com.hzqingcommon.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
@Service
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements IArticleService {
    public ArticleServiceImpl() {
        super.mapper="ArticleMapper";
    }
    @Autowired
    private IUserService userService;



    @Override
    public void saveOrUpdate(Article article,String token) {
        String username = JwtTokenUtil.getUsernameFromToken(token, secret);
        //获取用户信息
        User user = userService.getUserByUName(username);

        //表示第一次保存
        if (null == article.getId() || article.getId() == ""){
            article.setId(UUIDUtils.get32UUID());
            article.setArCtime(new Date());
            article.setArEtime(new Date());
            article.setUserId(user.getId());
            this.save(article);
        }else {
            this.update(article);
        }
    }
}
