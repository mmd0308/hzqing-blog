package hzqing.com.blogadmin.controller.blog;

import hzqing.com.blogadmin.service.blog.IWriteService;
import hzqing.com.hzqingcommon.controller.BaseController;
import hzqing.com.hzqingcommon.response.ResponseMessage;
import hzqing.com.hzqingcommon.util.DateUtils;
import hzqing.com.hzqingcommon.util.FileUtil;
import hzqing.com.hzqingcommon.util.UUIDUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/admin/blog/write")
public class WriteController extends BaseController<Map,IWriteService> {

    @Value("${blog.images.path}")
    private  String  filePath;

    /**
     * 上传图片，返回图片路径
     * @param file
     * @return
     */
    @PostMapping("/uploadImages")
    public ResponseMessage<String> uploadImages(@RequestParam("file") MultipartFile file){
        System.out.println();
        String fileName = UUIDUtils.get32UUID();
        String dataPaths =  DateUtils.getYearAndMonth() + "/";
        String fPath = filePath + dataPaths;
        fileName = fileName +file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        try {
            FileUtil.uploadFile(file.getBytes(),fPath,fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseMessage<>().success(dataPaths+fileName);
    }

}
