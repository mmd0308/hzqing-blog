package hzqing.com.hzqingcommon.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import hzqing.com.hzqingcommon.dao.IBaseDao;
import hzqing.com.hzqingcommon.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseServiceImpl<T> implements IBaseService<T> {
    @Autowired
    protected IBaseDao<T> baseDao;

    public String mapper;

    @Override
    public int save(T t) {
        return baseDao.save(mapper+".save",t);
    }

    @Override
    public T getById(String id) {
        return baseDao.selectById(mapper+".selectById",id);
    }

    @Override
    public PageInfo<T> queryPage(Integer start, Integer pageSize, T t) {
        if (null == start){
            start = 1;
        }
        if (null == pageSize){
            pageSize = 10;
        }
        PageHelper.startPage(start,pageSize);
        return new PageInfo<T>(baseDao.findForList(mapper+".query",t));
    }

    @Override
    public List<T> findAll() {
        return baseDao.findForList(mapper+".all",null);
    }


    public List<T> list(T t){
        return  null;
    }
}
