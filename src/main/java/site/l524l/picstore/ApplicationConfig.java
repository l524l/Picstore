package site.l524l.picstore;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;


@Configuration
public class ApplicationConfig {
	 @Bean
	    MultipartConfigElement multipartConfigElement() {
	        MultipartConfigFactory factory = new MultipartConfigFactory();
	        factory.setMaxFileSize(DataSize.ofMegabytes(40));
	        factory.setMaxRequestSize(DataSize.ofMegabytes(40));
	        return factory.createMultipartConfig();
	    }
}
