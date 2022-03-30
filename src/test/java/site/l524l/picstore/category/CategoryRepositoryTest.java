package site.l524l.picstore.category;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryRepositoryTest {
	@Autowired
	private CategoryRepository repo;
	
	
	@Test
	void findAllCategoryTest(){
		assertNotEquals(repo.findAll(), null);
	}
}
