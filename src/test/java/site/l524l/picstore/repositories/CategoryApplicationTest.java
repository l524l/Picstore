package site.l524l.picstore.repositories;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import site.l524l.picstore.category.CategoryRepository;

@SpringBootTest
public class CategoryApplicationTest {

	@Autowired
	CategoryRepository repo;
	
	@Test
	void findAllCategoryTest(){
		assertNotEquals(repo.findAll(), null);
	}
}
