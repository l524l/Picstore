package site.l524l.picstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class PicstoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(PicstoreApplication.class, args);
	}
}
