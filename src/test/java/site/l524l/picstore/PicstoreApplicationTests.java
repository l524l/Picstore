package site.l524l.picstore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import site.l524l.picstore.category.Category;
import site.l524l.picstore.picture.Picture;
import site.l524l.picstore.picture.PictureRepository;

@SpringBootTest
class PicstoreRepositoryTests {
	@Autowired
	PictureRepository repo;
	
	@Test
	void findByCategoryClass() {
		Category category = new Category("neko", false);

		Picture p = repo.findPictureByCategory(category).get(0);

		Assertions.assertEquals("34635de6-3987-453f-8db4-38d0a6a0b8f3", p.getId().toString());
	}
	
	@Test
	void findByCategoryString() {
		
		Picture p = repo.findPictureByCategory("neko").get(0);

		Assertions.assertEquals("34635de6-3987-453f-8db4-38d0a6a0b8f3", p.getId().toString());
	}
}
