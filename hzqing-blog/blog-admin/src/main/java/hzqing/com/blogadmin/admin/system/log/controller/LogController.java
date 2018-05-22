package hzqing.com.blogadmin.admin.system.log.controller;

import hzqing.com.blogadmin.admin.system.log.entity.Log;
import hzqing.com.blogadmin.admin.system.log.service.ILogService;
import hzqing.com.blogadmin.base.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/log")
public class LogController extends BaseController<Log,ILogService> {
}
