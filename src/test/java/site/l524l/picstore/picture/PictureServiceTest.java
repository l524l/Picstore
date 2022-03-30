package site.l524l.picstore.picture;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import site.l524l.picstore.category.Category;

@SpringBootTest
@Transactional
@Rollback(true)
public class PictureServiceTest {
	@Autowired
	private PictureService service;
	
	@Autowired
	private PictureRepository repository;
	
	
	@Test
	void saveMediaTest() {
		Picture picture = new Picture();
		Category category = new Category("neko", false);

		picture.setId(UUID.fromString("c5b5a155-04b7-43d1-b68f-287980184bc6"));
		picture.setExtension(".png");
		picture.setPath("/asd/");
		
		picture.setCategory(category);
		
		service.saveMedia(picture);
		
		Picture picture2 = repository.getById(UUID.fromString("c5b5a155-04b7-43d1-b68f-287980184bc6"));
		
		Assertions.assertEquals(picture2.getPath(), picture.getPath());
	}
	
	@Test
	void getRandomMediaTest() {
		Assertions.assertNotNull(service.getRandomMedia());
	}
	
	@Test
	void getRandomMediaByCategiryTest() {
		Category category = new Category("neko", false);
		
		Assertions.assertEquals(service.getRandomMediaByCategory(category).getCategory().getName(), category.getName());
	}
}
