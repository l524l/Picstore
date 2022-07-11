package site.l524l.picstore.controllers;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import site.l524l.picstore.category.CategoryRepository;
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
	
	
	@PreAuthorize("hasAuthority('PICTURE_ADMIN')")
	@PostMapping(value = "/upload")
	public ResponseEntity<?> uploadPicture(@RequestParam("category") String category, @RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			StorageFile storageFile = storageService.store(file);
			Picture pic = new Picture();
			
			pic.setId(UUID.fromString(storageFile.getFileName()));
			pic.setExtension(storageFile.getExtantion());
			pic.setCategory(repository.getById(category));
			pic.setPath(storageFile.getPath());
			
			pictureService.saveMedia(pic);
			
			return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
	}
	
	@GetMapping("/random")
	public ResponseEntity<?> randomPic() {
		return ResponseEntity.ok(pictureService.getRandomMedia());
	}
	
	@GetMapping("/randombycategoy")
	public ResponseEntity<?> randomByCategory(String category) {
		return ResponseEntity.ok(pictureService.getRandomMediaByCategory(category));
	}
}
