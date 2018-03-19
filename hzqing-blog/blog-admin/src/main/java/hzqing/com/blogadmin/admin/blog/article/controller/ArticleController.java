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

    @Value("${blog.images.path}")
    private String filePath;


    /**
     * 上传图片，返回图片路径
     * @param file
     * @return
     */
    @PostMapping("/uploadImages")
    public ResponseMessage<String> uploadImages(MultipartFile file){
        String dataPaths =  DateUtils.getYearAndMonth() + "/";
        String fPath = filePath + dataPaths;
        String fileName = UUIDUtils.get32UUID() +file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        try {
            FileUtil.uploadFile(file.getBytes(),fPath,fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseMessage<>().success("/images/"+dataPaths+fileName);
    }


    /**
     * 根据文章id，获取分类id,或者标签id
     * @param id
     * @return
     */
    @GetMapping("/getCateByAid/{id}")
    public ResponseMessage<List<String>> getCateByAid(@PathVariable String id) {
        List<String> cates = baseService.getCateByAid(id);
        return  new ResponseMessage<>().success(cates);
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
