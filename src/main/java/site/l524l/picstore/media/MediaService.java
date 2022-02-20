package site.l524l.picstore.media;

import java.util.UUID;

public interface MediaService<T extends Media> {
	
	void saveMedia(T media);
	
	Media getConcreetMedia(UUID id);
	
	Media getRandomMedia();
	
	void removeMedia(UUID media);
	
}
