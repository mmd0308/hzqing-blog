package hzqing.com.blogadmin.controller.blog;

import com.github.pagehelper.PageInfo;
import hzqing.com.blogadmin.entity.blog.Article;
import hzqing.com.blogadmin.service.blog.IArticleService;
import hzqing.com.blogadmin.vo.blog.ArticleVO;
import hzqing.com.hzqingcommon.controller.BaseController;
import hzqing.com.hzqingcommon.jwt.JwtTokenUtil;
import hzqing.com.hzqingcommon.response.ResponseMessage;
import hzqing.com.hzqingcommon.util.DateUtils;
import hzqing.com.hzqingcommon.util.FileUtil;
import hzqing.com.hzqingcommon.util.UUIDUtils;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Value("${blog.access.token}")
    private String token;

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

    @PostMapping("/saveOrUpdate")
    public ResponseMessage<Integer> add(@RequestBody Article article,HttpServletRequest request) {
        String tokens = request.getHeader(token);
        String username = JwtTokenUtil.getUsernameFromToken(tokens, secret);
        if (null== username || username == ""){
            return new ResponseMessage<>().tokenExpire();
        }
        baseService.saveOrUpdate(article,username);
        return  new ResponseMessage<>().success(article);
    }

    /**
     * 根据文章id，获取分类
     * @param id
     * @return
     */
    @GetMapping("/getCateByAid/{id}")
    public ResponseMessage<List<String>> getCateByAid(@PathVariable String id) {
        List<String> cates = baseService.getCateByAid(id);
        return  new ResponseMessage<>().success(cates);
    }
    @GetMapping("/pageByCid")
    public ResponseMessage<PageInfo<Article>> pageByCid(Integer page, Integer pageSize, Article article) {
        PageInfo<Article> res = baseService.queryPageByCid(page,pageSize,article);
        return new ResponseMessage<>().success(res);
    }

    @GetMapping("/pageIndex")
    public ResponseMessage<PageInfo<Article>> pageIndex(Integer page,Integer pageSize,Article t){
        PageInfo<Article> res = baseService.queryPageIndex(page,pageSize,t);
        return new ResponseMessage<>().success(res);
    }
}
