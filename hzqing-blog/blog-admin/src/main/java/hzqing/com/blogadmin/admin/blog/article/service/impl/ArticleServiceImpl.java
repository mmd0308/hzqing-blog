package hzqing.com.blogadmin.admin.blog.article.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import hzqing.com.blogadmin.admin.blog.article.vo.ArticleVO;
import hzqing.com.blogadmin.admin.system.user.service.IUserService;
import hzqing.com.blogadmin.base.service.impl.BaseServiceImpl;
import hzqing.com.blogadmin.admin.blog.article.entity.Article;
import hzqing.com.blogadmin.admin.system.user.entity.User;
import hzqing.com.blogadmin.admin.blog.article.service.IArticleService;
import hzqing.com.blogadmin.service.blog.IVisitService;
import hzqing.com.hzqingcommon.util.ReplaceStrUtil;
import hzqing.com.hzqingcommon.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements IArticleService {
    public ArticleServiceImpl() {
        super.mapper="ArticleMapper";
    }
    @Autowired
    private IUserService userService;
    @Autowired
    private IVisitService visitService;


    @Override
    public List<String> getCateByAid(String id) {
        return (List<String>) baseDao.findForList(mapper+".getCateByAid",id);
    }

    @Override
    public PageInfo<Article> getAllByTagId(Integer page, Integer pageSize, String id) {
        if (null != page && null != pageSize){ // 获取所有数据 带分页
            PageHelper.startPage(page,pageSize);
        }
        return new PageInfo<Article>((List<Article>) baseDao.findForList(mapper+".getAllByTagId",id));
    }

    @Override
    public void saveVo(ArticleVO t) {
        // 保存博客信息
        String aId = UUIDUtils.get32UUID();
        t.setId(aId);
        this.save(t);
        // 保存博客和类别关系
        Map<String,Object> rlTagArt = new HashMap<>();
        rlTagArt.put("id",UUIDUtils.get32UUID());
        rlTagArt.put("tagId",t.getTagId());
        rlTagArt.put("articleId",aId);
        this.saveRLAT(rlTagArt);
    }

    @Override
    public int update(Article article) {
        if (null != article.getArContentHtml() && article.getArContentHtml() != "") {
            String desc = ReplaceStrUtil.delHtmlTag(article.getArContentHtml());
            if (desc.length() > 200)
                article.setArDesc(desc.substring(0, 200));
            else
                article.setArDesc(desc);
        }
        return super.update(article);
    }

    /**
     * 新增博客和标签之间的关系
     * @param map
     */
    private void saveRLAT(Map<String,Object> map){
        baseDao.save(mapper+".saverlAT",map);
    }

}
