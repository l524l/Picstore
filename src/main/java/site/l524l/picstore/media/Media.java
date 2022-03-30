package site.l524l.picstore.media;

import java.util.UUID;

import site.l524l.picstore.category.Category;

public interface Media {
	
	void setId(UUID id);
	
	UUID getId();
	
	void setPath(String path);
	
	String getPath();
	
	void setExtension(String extension);
	
	String getExtantion();
	
	void setCategory(Category category);
	
	Category getCategory();
	
}
	