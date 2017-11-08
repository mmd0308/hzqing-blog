package hzqing.com.hzqingcommon.service;

public interface IBaseService<T> {

    int save(T t);

     T getById(String id);
}
