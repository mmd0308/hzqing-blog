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

import java.util.*;

@Service
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements IArticleService {
    public ArticleServiceImpl() {
        super.mapper="ArticleMapper";
    }
    @Autowired
    private IUserService userService;



    @Override
    public void saveOrUpdate(Article article,String username) {
        //获取用户信息
        User user = userService.getUserByUName(username);
        //表示第一次保存
        if (null == article.getId() || article.getId() == ""){
            String uuid = UUIDUtils.get32UUID();
            article.setId(uuid);
            article.setArCtime(new Date());
            article.setArEtime(new Date());
            article.setUserId(user.getId());
            this.save(article);
            if (null != article.getCateId() && article.getCateId().size()>0){
                saveRLCateOrArt(article);
            }

        }else {
            this.update(article);
            if (null != article.getCateId() && article.getCateId().size()>0){
                deleRlCateByArtId(article.getId());
                saveRLCateOrArt(article);
            }
        }
    }

    @Override
    public List<String> getCateByAid(String id) {
        return (List<String>) baseDao.findForList(mapper+".getCateByAid",id);
    }

    /**
     * 新增文章和分类关系
     * @param article
     */
    private void saveRLCateOrArt(Article article){
        List<String> cateId = article.getCateId();
        List<Map> cates = new ArrayList<>();
        for (String str : cateId){
            HashMap<String,String> m= new HashMap<>();
            m.put("cateId",str);
            m.put("articleId",article.getId());
            cates.add(m);
        }
        baseDao.save(mapper+ ".saveRlCateOrArt",cates);
    }

    private void deleRlCateByArtId(String id){
        baseDao.delete(mapper+".deleRlCateByArtId",id);
    }
}
