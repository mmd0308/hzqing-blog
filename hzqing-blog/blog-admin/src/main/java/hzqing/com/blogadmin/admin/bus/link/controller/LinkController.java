package hzqing.com.blogadmin.admin.bus.link.controller;

import hzqing.com.blogadmin.admin.bus.link.entity.Link;
import hzqing.com.blogadmin.admin.bus.link.service.ILinkService;
import hzqing.com.blogadmin.base.controller.BaseController;
import hzqing.com.blogadmin.utils.ResponseMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bus/link")
public class LinkController extends BaseController<Link,ILinkService> {

    @GetMapping("/show/all")
    public ResponseMessage<List<Link>> showAll() {
        Link link = new Link();
        link.setLinkState("TG");
        return new ResponseMessage<>().success(baseService.findAll(link));
    }
}
