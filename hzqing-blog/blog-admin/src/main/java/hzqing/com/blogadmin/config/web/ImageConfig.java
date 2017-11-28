package hzqing.com.blogadmin.config.web;

import hzqing.com.blogadmin.interceptor.TokenInterceptor;
import hzqing.com.blogadmin.interceptor.VisitInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class ImageConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:///home/hzq/hblog/");
    }

    /**
     * 防止visitInterceptor拦截器中IVisitService Bean注入不进来的问题
     * @return
     */
    @Bean
    VisitInterceptor visitInterceptor(){
        return new VisitInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(visitInterceptor()).addPathPatterns("/admin/blog/article/get/**");
        super.addInterceptors(registry);
    }
}
