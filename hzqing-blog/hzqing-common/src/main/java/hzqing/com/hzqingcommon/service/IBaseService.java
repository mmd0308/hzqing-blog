package hzqing.com.hzqingcommon.service;

public interface IBaseService<T> {
    void save(T t);

    void update(T t);
}
