package site.l524l.picstore.storage;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileExtention {
	
	public static String getExtention(String path) {
		return path.substring(path.lastIndexOf("."));
	}
	
	public static String getExtention(Path path) {
		if(Files.isRegularFile(path)) {
			 return getExtention(path.getFileName());
		}
		return null;
	}
	
	public static String getExtention(File file) {
		return getExtention(file.toPath());
	}
}
