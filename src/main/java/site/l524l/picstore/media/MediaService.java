package site.l524l.picstore.media;

public interface MediaService<T extends Media> {
	
	void addMedia(T media);
	
	Media getConcreetMedia(T media);
	
	Media getRandomMedia();
	
	void removeMedia(T media);
	
}
