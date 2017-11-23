package hzqing.com.hzqingcommon.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import hzqing.com.hzqingcommon.dao.IBaseDao;
import hzqing.com.hzqingcommon.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class BaseServiceImpl<T> implements IBaseService<T> {
    @Autowired
    protected IBaseDao baseDao;

    @Value("${admin.jwt.secret}")
    protected String secret;

    public String mapper;

    @Override
    public int save(T t) {
        return (int) baseDao.save(mapper+".save",t);
    }

    @Override
    public T getById(String id) {
        return (T) baseDao.selectById(mapper+".selectById",id);
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
        return new PageInfo<T>((List<T>) baseDao.findForList(mapper+".query",t));
    }

    @Override
    public List<T> findAll() {
        return (List<T>) baseDao.findForList(mapper+".all",null);
    }

    @Override
    public int update(T t) {
        return (int) baseDao.update(mapper+".update",t);
    }

    @Override
    public int deletedById(String id) {
        return (int) baseDao.delete(mapper+".deletedById",id);
    }


    public List<T> list(T t){
        return  null;
    }
}
