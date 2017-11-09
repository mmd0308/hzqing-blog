package hzqing.com.blogadmin;

import hzqing.com.hzqingcommon.dao.IBaseDao;
import hzqing.com.hzqingcommon.dao.impl.BaseDaoImpl;
import hzqing.com.hzqingcommon.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BlogAdminApplication {


	public static void main(String[] args) {
		SpringApplication.run(BlogAdminApplication.class, args);
	}

	/**
	 * 注入公共的dao
	 * @return
	 */
	@Bean
	public IBaseDao baseDao(){
		return  new BaseDaoImpl();
	}
}
