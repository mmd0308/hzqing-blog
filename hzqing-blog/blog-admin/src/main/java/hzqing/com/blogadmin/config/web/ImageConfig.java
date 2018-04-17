package hzqing.com.blogadmin.config.web;

import hzqing.com.blogadmin.interceptor.TokenInterceptor;
import hzqing.com.blogadmin.interceptor.VisitInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class ImageConfig extends WebMvcConfigurerAdapter {
    @Value("${blog.images.path}")
    private String filePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file://"+ filePath);
    }

    /**
     * 防止visitInterceptor拦截器中IVisitService Bean注入不进来的问题
     * @return
     */
    @Bean
    VisitInterceptor visitInterceptor(){
        return new VisitInterceptor();
    }
    @Bean
    TokenInterceptor tokenInterceptor() { return  new TokenInterceptor();}

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/user/login","/**/show/**");
        registry.addInterceptor(visitInterceptor()).addPathPatterns("/admin/blog/article/show/get/**");
        super.addInterceptors(registry);
    }



}
