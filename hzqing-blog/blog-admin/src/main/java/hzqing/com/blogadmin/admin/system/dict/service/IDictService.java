package hzqing.com.blogadmin.admin.system.dict.service;

import hzqing.com.blogadmin.admin.system.dict.entity.Dict;
import hzqing.com.blogadmin.admin.system.dict.vo.DictVO;
import hzqing.com.blogadmin.base.service.IBaseService;

import java.util.List;

public interface IDictService extends IBaseService<Dict> {
    List<DictVO> getTree(String id);
}
