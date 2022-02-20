package site.l524l.picstore;

import java.nio.file.Paths;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import site.l524l.picstore.storage.FileSystemStorageService;


@Configuration
public class ApplicationConfig {
	
	@Value("${storage.images.defaultpath}")
	String basePath;
	@Bean
	public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.ofMegabytes(40));
        factory.setMaxRequestSize(DataSize.ofMegabytes(40));
        return factory.createMultipartConfig();
    }
	
	@Bean
	public FileSystemStorageService storageServiceConfig() {
		return new FileSystemStorageService(Paths.get(basePath));
	}
}
