package hzqing.com.blogadmin.admin.bus.works.controller;

import hzqing.com.blogadmin.admin.bus.works.entity.Works;
import hzqing.com.blogadmin.admin.bus.works.service.IWorksService;
import hzqing.com.blogadmin.base.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/bus/works")
public class WorksController extends BaseController<Works,IWorksService> {
}
