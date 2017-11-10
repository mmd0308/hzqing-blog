package hzqing.com.hzqingcommon.dao;

import java.util.List;
import java.util.Map;

public interface IBaseDao<T>{
    /**
     * 保存
     * @param str
     * @param obj
     * @return
     */
    public int save(String str, Object obj);

    /**
     * 修改
     * @param str
     * @param obj
     * @return
     */
    public int update(String str, Object obj);

    /**
     * 删除
     * @param str
     * @param obj
     * @return
     */
    public int delete(String str, Object obj);

    /**
     * 返回一个对象
     * @param str
     * @param obj
     * @return
     */
    public T findForObject(String str, Object obj) ;

    /**
     * 根据id获取数据
     * @param str
     * @param id
     * @return
     */
    public T selectById(String str,String id);

    /**
     * 获取所有的数据 带分页
     * @param str
     * @param obj
     * @return
     */
    public List<T> findForList(String str, Object obj) ;

    public Object findForMap(String sql, Object obj, String key, String value) ;

    /**
     * 批量新增
     * @param s
     * @param lists
     * @return
     */
    int batchSave(String s, List<Map<String,String>> lists);
}
