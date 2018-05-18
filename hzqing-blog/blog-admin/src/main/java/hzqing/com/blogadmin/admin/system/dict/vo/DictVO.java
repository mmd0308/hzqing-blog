package hzqing.com.blogadmin.admin.system.dict.vo;

import hzqing.com.blogadmin.admin.system.dict.entity.Dict;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("dictvo")
public class DictVO extends Dict {
    private List<DictVO> children;

    public List<DictVO> getChildren() {
        return children;
    }

    public void setChildren(List<DictVO> children) {
        this.children = children;
    }
}
