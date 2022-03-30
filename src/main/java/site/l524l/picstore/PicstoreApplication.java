package site.l524l.picstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class PicstoreApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(PicstoreApplication.class, args);
	}
}
