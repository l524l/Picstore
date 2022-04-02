package site.l524l.picstore;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import site.l524l.picstore.category.CategoryRepository;
import site.l524l.picstore.media.Media;
import site.l524l.picstore.media.MediaService;
import site.l524l.picstore.picture.Picture;
import site.l524l.picstore.storage.StorageFile;
import site.l524l.picstore.storage.StorageService;

@RestController
@RequestMapping("/picture")
public class PictureController {
	
	private final StorageService storageService;
	
	private final MediaService<Picture> pictureService;
	
	private final CategoryRepository repository;
	
	
	public PictureController(StorageService storageService, MediaService<Picture> pictureService, CategoryRepository repository) {
		this.storageService = storageService;
		this.pictureService = pictureService;
		this.repository = repository;
	}
	
	
	@PostMapping(value = "/upload")
	public String uploadPicture(@RequestParam("category") String category, @RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			StorageFile storageFile = storageService.store(file);
			Picture pic = new Picture();
			
			pic.setId(UUID.fromString(storageFile.getFileName()));
			pic.setExtension(storageFile.getExtantion());
			pic.setCategory(repository.getById(category));
			pic.setPath(storageFile.getPath());
			
			pictureService.saveMedia(pic);
			
			return "ok";
        } else {
            return "Вам не удалось загрузить";
        }
	}
	
	@GetMapping("/random")
	public Media randomPic() {
		return pictureService.getRandomMedia();
	}
	
	@GetMapping("/randombycategoy")
	public Media randomByCategory(String category) {
		return pictureService.getRandomMediaByCategory(category);
	}
}
