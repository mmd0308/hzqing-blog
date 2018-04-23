package hzqing.com.blogadmin.constant;

public class Constant {
    /**
     * 用户的id
     */
    public static final String USER_ID = "USER_ID";

    /**
     * JWT的签名密钥
     */
    public static final String JWT_SECRET = "hzqing.com";
    /**
     * jwt的过期时间  单位秒
     */
    public static final int JWT_EXPIRATION = 1800;
    /**
     * AES对称加密密钥
     */
    public static final String AES_SECRET = "HZQING.COM";

    /**
     * 传递token的key值
     */
    public static final String ACCESS_TOKEN_KEY = "ACCESS-TOKEN";
    /**
     * 跟新token时候的key值
     */
    public static final String REPLACE_TOKEN_KEY = "REPLACE_TOKEN";

    /**
     * 返回成功 状态200
     */
    public static final int WEB_RESPONSE_STATUES_SUCCESS = 200;


    /**
     * 登录失败  登录名或者密码错误  308001
     */
    public static final int WEB_RESPONSE_STATUES_LOGIN_ERROR = 308001;

    /**
     * 提示前端跟新token
     */
    public static final int WEB_RESPONSE_STATUES_REPLACE_TOKEN = 308100;

    /**
     * 404
     */
    public static final int WEB_RESPONSE_STATUES_ERROR = 404;
    /**
     * 博客状态 发布编码
     */
    public static final String BLOG_STATE_FB = "FB";
    /**
     *  博客状态 发布
     */
    public static final String BLOG_STATE_FB_REP = "发布";

    /**
     * 博客状态 草稿编码
     */
    public static final String BLOG_STATE_CG = "CG";
    /**
     *  博客状态 草稿
     */
    public static final String BLOG_STATE_CG_REP = "草稿";
}