package site.l524l.picstore.storage;

import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
	
	StorageFile store(MultipartFile file);
	
	Path loadFile(String filename);
	
	void removeFile(String filename);
	
	void init();
	
}
