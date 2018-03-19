package hzqing.com.blogadmin.interceptor;

import hzqing.com.blogadmin.admin.system.user.service.IUserService;
import hzqing.com.blogadmin.constant.Constant;
import hzqing.com.blogadmin.admin.system.user.entity.User;
import hzqing.com.hzqingcommon.jwt.JwtTokenUtil;
import hzqing.com.hzqingcommon.util.AESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private IUserService userService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String tokens = request.getHeader(Constant.ACCESS_TOKEN_KEY);
        request.setAttribute(Constant.REPLACE_TOKEN_KEY,false);
        if (null == tokens) { //判断token是否存在
            return false;
        }
        long res = JwtTokenUtil.checkJwtExpired(tokens,Constant.JWT_SECRET);
        // 校验token是否正确
        if (res == -1) { // jwt过期,生成新的jwt
            return false;
        }
        if (res <= 180){ // 校验token过期时间是否接近临界值 默认是3分钟
            request.setAttribute(Constant.REPLACE_TOKEN_KEY,true);
        }
        // 校验token信息是否准确。在多终端登录时候密码修改需要全部重新登录
        String iss = (String) JwtTokenUtil.getObjectFromToken(tokens, Constant.JWT_SECRET, "iss");
        iss = AESUtil.AESDncode(Constant.AES_SECRET, iss);
        String[] split = iss.split(",");
        if (split.length == 3 ){
            request.setAttribute(Constant.USER_ID,split[0]); //存储用户id到request请求中
            String username = split[1];
            String password = split[2];
            User user = userService.getUserByUName(username);
            if (null != user && user.getPassword().equals(password)){ //用户名和密码正确，校验通过
                return true;
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }

}
