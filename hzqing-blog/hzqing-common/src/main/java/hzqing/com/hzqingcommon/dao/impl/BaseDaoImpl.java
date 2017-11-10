package hzqing.com.hzqingcommon.dao.impl;

import hzqing.com.hzqingcommon.dao.IBaseDao;
import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public class BaseDaoImpl<T> implements IBaseDao<T> {
    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;


    public int save(String str, Object obj) {
        return sqlSessionTemplate.insert(str, obj);
    }

    public int update(String str, Object obj)  {
        return sqlSessionTemplate.update(str, obj);
    }

    public Object batchDelete(String str, List<Object> objs ){
        return sqlSessionTemplate.delete(str, objs);
    }

    public int delete(String str, Object obj)  {
        return sqlSessionTemplate.delete(str, obj);
    }

    public T findForObject(String str, Object obj)  {
        return sqlSessionTemplate.selectOne(str, obj);
    }

    @Override
    public T selectById(String str, String id) {
        return sqlSessionTemplate.selectOne(str,id);
    }

    public List<T> findForList(String str, Object obj)  {
        return sqlSessionTemplate.selectList(str, obj);
    }

    public Object findForMap(String str, Object obj, String key, String value)  {
        return sqlSessionTemplate.selectMap(str, obj, key);
    }

    @Override
    public int batchSave(String s, List<Map<String, String>> lists) {
        return sqlSessionTemplate.insert(s,lists);
    }


}
