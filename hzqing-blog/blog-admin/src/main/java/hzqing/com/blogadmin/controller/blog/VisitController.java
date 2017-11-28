package hzqing.com.blogadmin.controller.blog;

import hzqing.com.blogadmin.entity.blog.Visit;
import hzqing.com.blogadmin.service.blog.IVisitService;
import hzqing.com.hzqingcommon.controller.BaseController;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin/blog/visit")
public class VisitController extends BaseController<Visit,IVisitService> {

}
