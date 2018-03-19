package hzqing.com.blogadmin.utils;

import hzqing.com.blogadmin.constant.Constant;

public class BlogStateUtil {
    /**
     * 博客状态 编码和汉字转换
     * @param code 状态编码
     * @return
     */
    public static String replaceBlogState(String code){
        if (null == code){
            if (Constant.BLOG_STATE_CG.equals(code))
                return Constant.BLOG_STATE_CG_REP;
            else if (Constant.BLOG_STATE_FB.equals(code))
                return Constant.BLOG_STATE_FB_REP;
        }
        return null;
    }
}
