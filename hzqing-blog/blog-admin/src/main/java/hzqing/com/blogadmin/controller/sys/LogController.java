package hzqing.com.blogadmin.controller.sys;

import hzqing.com.blogadmin.base.controller.BaseController;
import hzqing.com.blogadmin.entity.sys.Log;
import hzqing.com.blogadmin.service.sys.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/log")
public class LogController extends BaseController<Log,ILogService> {
}
