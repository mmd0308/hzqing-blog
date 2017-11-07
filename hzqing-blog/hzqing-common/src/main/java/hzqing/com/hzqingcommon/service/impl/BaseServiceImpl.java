package hzqing.com.hzqingcommon.service.impl;

import hzqing.com.hzqingcommon.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

public class BaseServiceImpl<T> implements IBaseService<T> {
    @Autowired
    private Mapper<T> mapper;

    @Override
    public void save(T t) {
        mapper.insert(t);
    }

    @Override
    public void update(T t) {
        mapper.updateByPrimaryKey(t);
    }
}
