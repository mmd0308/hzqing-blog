package hzqing.com.hzqingcommon.controller;

import hzqing.com.hzqingcommon.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class BaseController<T> {
    @Autowired
    private IBaseService baseService;

    @PostMapping(value = "/add")
    @ResponseBody
    public String add(T t){
        baseService.save(t);
        return "base_add";
    }
    @PutMapping(value = "/update")
    public String update(@RequestBody T t){
        baseService.update(t);
        return null;
    }
    @GetMapping(value = "/get/{id}")
    public T get(@PathVariable String id){
        return null;
    }

}
