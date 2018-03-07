package hzqing.com.blogadmin.controller.blog;

import hzqing.com.blogadmin.base.controller.BaseController;
import hzqing.com.blogadmin.entity.blog.CateGory;
import hzqing.com.blogadmin.service.blog.ICateGoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/blog/categroy")
public class CateGoryController extends BaseController<CateGory,ICateGoryService> {
}
