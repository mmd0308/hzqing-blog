package hzqing.com.blogadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@SpringBootApplication
@EnableSwagger2
@EnableTransactionManagement
public class BlogAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogAdminApplication.class, args);
	}
}
