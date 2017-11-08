package hzqing.com.hzqingcommon.controller;

import hzqing.com.hzqingcommon.response.ResponseMessage;
import hzqing.com.hzqingcommon.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class BaseController<T,M extends IBaseService<T>> {
    @Autowired
    private M baseService;

    /**
     * 新增
     * @param t
     * @return 返回状态码和影响行数目
     */
    @PostMapping("/add")
    public ResponseMessage<Integer> add(T t){
        return  new ResponseMessage<Integer>().success(baseService.save(t));
    }

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public ResponseMessage<T> get(@PathVariable String id){
        T t = baseService.getById(id);
        return new ResponseMessage<T>().success(t);
    }

    /**
     * 根据id进行修改
     * @param t
     * @return
     */
    @PutMapping("/put/{id}")
    public ResponseMessage<String> update(T t){
        return  new ResponseMessage<>().success("");
    }




}
