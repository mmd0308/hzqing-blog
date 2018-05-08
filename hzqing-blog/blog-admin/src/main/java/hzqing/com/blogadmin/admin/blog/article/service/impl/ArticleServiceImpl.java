package hzqing.com.blogadmin.admin.blog.article.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import hzqing.com.blogadmin.admin.blog.article.vo.ArticleVO;
import hzqing.com.blogadmin.admin.system.user.service.IUserService;
import hzqing.com.blogadmin.base.service.impl.BaseServiceImpl;
import hzqing.com.blogadmin.admin.blog.article.entity.Article;
import hzqing.com.blogadmin.admin.blog.article.service.IArticleService;
import hzqing.com.blogadmin.admin.blog.visit.service.IVisitService;
import hzqing.com.hzqingcommon.util.ReplaceStrUtil;
import hzqing.com.hzqingcommon.util.UUIDUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
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
    public PageInfo<ArticleVO> showAllPage(Integer start, Integer pageSize, ArticleVO t) {
        if (null == start){
            start = 1;
        }
        if (null == pageSize){
            pageSize = 10;
        }
        PageHelper.startPage(start,pageSize);
        PageInfo<ArticleVO> pageInfo = new PageInfo<ArticleVO>((List<ArticleVO>) baseDao.findForList(mapper+".showAllPage",t));
        return pageInfo;
    }

    @Override
    public ArticleVO getShowById(String id) {
        ArticleVO res = (ArticleVO) baseDao.findForObject(mapper + ".getShowById", id);
        return res;
    }

    @Override
    public int update(Article article) {
        if (null != article.getArContentHtml() && article.getArContentHtml() != "") {
            String desc = ReplaceStrUtil.delHtmlTag(article.getArContentHtml());
            if (desc.length() > 300)
                article.setArDesc(desc.substring(0, 300));
            else
                article.setArDesc(desc);
            //获取博客图片
            Document parse = Jsoup.parse(article.getArContentHtml());
            Elements imgs = parse.select("img[src]");
            if (imgs.size() > 0 ) {
                article.setArImg(imgs.get(0).attributes().get("src"));
            }
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
