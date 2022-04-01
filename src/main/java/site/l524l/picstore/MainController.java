package site.l524l.picstore;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import site.l524l.picstore.category.CategoryRepository;
import site.l524l.picstore.media.Media;
import site.l524l.picstore.media.MediaService;
import site.l524l.picstore.picture.Picture;
import site.l524l.picstore.storage.StorageFile;
import site.l524l.picstore.storage.StorageService;

@Controller
public class MainController {
	
	private StorageService storageService;
	
	private MediaService<Picture> pictureService;
	
	@Autowired
	private CategoryRepository repository;
	
	
	public MainController(StorageService storageService, MediaService<Picture> pictureService) {
		this.storageService = storageService;
		this.pictureService = pictureService;
	}
	
	
	@RequestMapping("/")
	public @ResponseBody String test() {
		return "<h1>ок</h1>";
	}
	
	@RequestMapping(path = "/upload", method = RequestMethod.POST)
	public @ResponseBody String upload(@RequestParam("category") String category, @RequestParam("file") MultipartFile file) {
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
	
	@RequestMapping("/random")
	public @ResponseBody Media randomPic() {
		return pictureService.getRandomMedia();
	}
	
	@RequestMapping("/randombycategoy")
	public @ResponseBody Media randomByCategory(String category) {
		return pictureService.getRandomMediaByCategory(category);
	}
}