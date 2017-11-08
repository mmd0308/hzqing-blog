package hzqing.com.hzqingcommon.service.impl;

import hzqing.com.hzqingcommon.dao.IBaseDao;
import hzqing.com.hzqingcommon.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseServiceImpl<T> implements IBaseService<T> {
    @Autowired
    private IBaseDao<T> baseDao;

    public String mapper;

    @Override
    public int save(T t) {
        return baseDao.save(mapper+".save",t);
    }

    @Override
    public T getById(String id) {
        return baseDao.selectById(mapper+".selectById",id);
    }
}
