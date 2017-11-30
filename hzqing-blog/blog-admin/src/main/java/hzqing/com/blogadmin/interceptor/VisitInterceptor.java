package hzqing.com.blogadmin.interceptor;

import hzqing.com.blogadmin.entity.blog.Visit;
import hzqing.com.blogadmin.service.blog.IVisitService;
import hzqing.com.hzqingcommon.jwt.JwtTokenUtil;
import hzqing.com.hzqingcommon.util.HostUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class VisitInterceptor implements HandlerInterceptor {
    @Autowired
    private IVisitService visitService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String str = request.getRequestURI();
        str = str.substring(str.lastIndexOf("/")+1);
        Visit v = new Visit();
        v.setvTime(new Date());
        v.setArticleId(str);
        v.setvIp(HostUtil.getRemoteHost(request));
        v.setvClicks(1);
        v.setvSupport(0);
        visitService.save(v);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


}
