package hzqing.com.hzqingcommon.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import hzqing.com.hzqingcommon.response.ResponseMessage;
import hzqing.com.hzqingcommon.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BaseController<T,M extends IBaseService<T>> {
    @Autowired
    protected M baseService;

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

    /**
     * 按照条件查询，默认查询所有 带分页
     * @param
     * @return
     */
    @GetMapping("/page")
    public ResponseMessage<PageInfo<T>> page(Integer page,Integer pageSize,T t){
        PageInfo<T> res = baseService.queryPage(page,pageSize,t);
        return new ResponseMessage<>().success(res);
    }

    /**
     * 获取所有数据
     * @return
     */
    @GetMapping("/all")
    public ResponseMessage<List<T>> all(){
        return new ResponseMessage<List<T>>().success(baseService.findAll());
    }



}
