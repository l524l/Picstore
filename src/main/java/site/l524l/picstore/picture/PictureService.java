package site.l524l.picstore.picture;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import site.l524l.picstore.media.Media;
import site.l524l.picstore.media.MediaService;

@Service
public class PictureService implements MediaService<Picture> {
	
	private final PictureRepository repository;
	
	private final Random random;

	
	public PictureService(PictureRepository repository) {
		this.repository = repository;
		this.random = new Random();
	}

	
	@Override
	public void saveMedia(Picture media) {
		repository.save(media);
	}

	@Override
	public Media getConcreetMedia(UUID id) {
		return repository.findById(id).orElseThrow();
	}

	@Override
	public Media getRandomMedia() {
		Long count = repository.count();
		int member = random.nextInt(count.intValue());

		return repository.findAll(PageRequest.of(member, 1)).toList().get(0);
	}

	@Override
	public void removeMedia(UUID id) {
		repository.deleteById(id);
	}

	@Override
	public Media getRandomMediaByCategory(String category) {
		int count = repository.countByCategory(category);
		int member = random.nextInt(count);

		List<Picture> list = repository.findPictureByCategory(category, PageRequest.of(member, 1));

		return list.get(0);
	}
}
