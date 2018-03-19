package hzqing.com.blogadmin.controller.blog;

import hzqing.com.blogadmin.base.controller.BaseController;
import hzqing.com.blogadmin.entity.blog.Visit;
import hzqing.com.blogadmin.service.blog.IVisitService;
import hzqing.com.blogadmin.utils.ResponseMessage;
import hzqing.com.hzqingcommon.util.HostUtil;
import hzqing.com.hzqingcommon.util.UUIDUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@RestController
@RequestMapping("/admin/blog/visit")
public class VisitController extends BaseController<Visit,IVisitService> {
    /**
     * 访问次数
     * @return
     */
    @GetMapping("/getVisitNum")
    public ResponseMessage<Integer> getVisitNum() {
        int vNum = baseService.getVisitNum();
        return new ResponseMessage<>().success(vNum);
    }


    @GetMapping("/getVisitNumByAId/{id}")
    public ResponseMessage<Integer> getVisitNumByAId(@PathVariable String id) {
        int vNum = baseService.getVisitNumByAId(id);
        return new ResponseMessage<>().success(vNum);
    }


    @PostMapping("/saveSupport/{id}")
    public ResponseMessage<Visit> saveSupport(HttpServletRequest request){
        String str = request.getRequestURI();
        str = str.substring(str.lastIndexOf("/")+1);
        Visit v = new Visit();
        v.setId(UUIDUtils.get32UUID());
        v.setvTime(new Date());
        v.setArticleId(str);
        v.setvIp(HostUtil.getRemoteHost(request));
        v.setvClicks(0);
        v.setvSupport(1);
        baseService.save(v);
        return  new ResponseMessage<Visit>().success(v);
    }

    @GetMapping("/getSupportNumByAId/{id}")
    public ResponseMessage<Integer> getSupportNumByAId(@PathVariable String id) {
        int vNum = baseService.getSupportNumByAId(id);
        return new ResponseMessage<>().success(vNum);
    }
}

