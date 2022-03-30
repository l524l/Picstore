package site.l524l.picstore.storage;

public class StorageFile {
	
	private String fileName;
	
	private String extantion;
	
	private String path;
	
	
	public StorageFile(String fileName, String extantion, String path) {
		this.fileName = fileName;
		this.extantion = extantion;
		this.path = path;
	}
	
	
	public String getFileName() {
		return fileName;
	}
	
	public String getExtantion() {
		return extantion;
	}
	
	public String getPath() {
		return path;
	}
}
