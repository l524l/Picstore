package site.l524l.picstore.media;

public interface MediaService {
	
	void addMedia(Media media);
	
	Media getConcreetMedia(Media media);
	
	Media getRandomMedia();
	
	void removeMedia(Media media);
	
	
	
}
