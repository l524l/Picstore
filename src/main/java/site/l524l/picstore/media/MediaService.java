package site.l524l.picstore.media;

import java.util.UUID;

import site.l524l.picstore.category.Category;

public interface MediaService<T extends Media> {
	
	void saveMedia(T media);
	
	Media getConcreetMedia(UUID id);
	
	Media getRandomMediaByCategory(Category category);
	
	Media getRandomMedia();
	
	void removeMedia(UUID media);
	
}
