package site.l524l.picstore.storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public final class FileSystemStorageService implements StorageService {
	
	private Path basePath;
	
	public FileSystemStorageService(Path basePath) {
		this.basePath = basePath;
	}
	
	@Override
	public String store(MultipartFile file) {
		String name = UUID.randomUUID().toString();
		
		String extention = FileExtention.getExtention(file.getOriginalFilename());
		
		try {
			Files.copy(file.getInputStream(), basePath.resolve(name+extention));
		
			return basePath.resolve(name+extention).toString();
		} catch (IOException e) {
			// TODO add specific exception 
			throw new RuntimeException();
		}
	}

	@Override
	public Path loadFile(String filename) {
		Path p = basePath.resolve(filename);
		
		if(Files.isRegularFile(p) && Files.exists(p)) {
			return p;
		}
		// TODO add specific exception 
		throw new RuntimeException();
	}

	@Override
	public void removeFile(String filename) {
		try {
			Files.deleteIfExists(basePath.resolve(filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void init() {
		if(Files.notExists(basePath)) {
			try {
				Files.createDirectories(basePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
