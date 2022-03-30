package site.l524l.picstore.storage;

import java.io.File;
import java.nio.file.Path;

public class FileExtention {
	public static String getExtention(String path) {
		
		if(path.lastIndexOf(".") == -1) return null;
		
		return path.substring(path.lastIndexOf("."));
	}
	
	public static String getExtention(Path path) {
		return getExtention(path.toString());
	}
	
	public static String getExtention(File file) {
		return getExtention(file.toPath());
	}
}
