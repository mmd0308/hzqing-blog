package hzqing.com.blogadmin.controller.blog;

import hzqing.com.blogadmin.entity.blog.Article;
import hzqing.com.blogadmin.service.blog.IArticleService;
import hzqing.com.hzqingcommon.controller.BaseController;
import hzqing.com.hzqingcommon.response.ResponseMessage;
import hzqing.com.hzqingcommon.util.DateUtils;
import hzqing.com.hzqingcommon.util.FileUtil;
import hzqing.com.hzqingcommon.util.UUIDUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


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
        baseService.saveOrUpdate(article,tokens);
        return  new ResponseMessage<>().success(article);
    }
}
