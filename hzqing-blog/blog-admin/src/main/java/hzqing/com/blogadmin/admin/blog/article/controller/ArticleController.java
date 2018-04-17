package hzqing.com.blogadmin.admin.blog.article.controller;

import com.github.pagehelper.PageInfo;
import hzqing.com.blogadmin.admin.blog.article.vo.ArticleVO;
import hzqing.com.blogadmin.base.controller.BaseController;
import hzqing.com.blogadmin.constant.Constant;
import hzqing.com.blogadmin.admin.blog.article.entity.Article;
import hzqing.com.blogadmin.admin.blog.article.service.IArticleService;
import hzqing.com.blogadmin.utils.ResponseMessage;
import hzqing.com.hzqingcommon.jwt.JwtTokenUtil;
import hzqing.com.hzqingcommon.util.DateUtils;
import hzqing.com.hzqingcommon.util.FileUtil;
import hzqing.com.hzqingcommon.util.UUIDUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/admin/blog/article")
public class ArticleController extends BaseController<Article,IArticleService> {
    /**
     * 博客展示页面
     * @param page
     * @param pageSize
     * @param t
     * @return
     */
    @GetMapping("/show/page")
    public ResponseMessage<PageInfo<ArticleVO>> page(Integer page,Integer pageSize,ArticleVO t){
        PageInfo<ArticleVO> res = baseService.showAllPage(page,pageSize,t);
        return new ResponseMessage<>().success(res);
    }


    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @GetMapping("/show/get/{id}")
    public ResponseMessage<Article> get(@PathVariable String id){
        Article t = baseService.getById(id);
        return new ResponseMessage<Article>().success(t);
    }

    /**
     * 根据标签id,获取博客
     * @param page page == null 不带分页
     * @param pageSize pageSize == null 不带分页
     * @param id 标签id
     * @return
     */
    @GetMapping("/getAllByTagId/{id}")
    public ResponseMessage<PageInfo<Article>> getAllByTagId(Integer page,Integer pageSize, @PathVariable String id){
        PageInfo<Article> res = baseService.getAllByTagId(page,pageSize,id);
        return new ResponseMessage<>().success(res);
    }

    /**
     * 新增
     * @param t
     * @return 返回状态码和影响行数目
     */
    @PostMapping("/addVo")
    public ResponseMessage add(@RequestBody ArticleVO t, HttpServletRequest request){
        t.setUserId((String) request.getAttribute(Constant.USER_ID));
        baseService.saveVo(t);
        return  new ResponseMessage<>().success();
    }

}
