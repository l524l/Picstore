package site.l524l.picstore;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import site.l524l.picstore.category.Category;
import site.l524l.picstore.category.CategoryRepository;

@RestController
@RequestMapping("/category")
public class CategoryController {

	private final CategoryRepository repository;
	
	
	public CategoryController(CategoryRepository repository) {
		this.repository = repository;
	}
	
	
	@PostMapping(value = "/add")
	public String addCategory(@RequestBody Category category) {
		if (repository.existsById(category.getName())) {
			return "Category already exist!";
		}
		
		repository.save(category);
	
		return "ok";
	}
	
	@GetMapping(value = "/remove")
	public String removeCategory(@RequestParam String name) {
		repository.deleteById(name);
		
		return "ok";
	}
	
	@PostMapping(value = "/change")
	public String changeCategory(@RequestBody Category category) {
		if (repository.existsById(category.getName()) == false) {
			return "Category doesn't exist!";
		}
		
		repository.save(category);
		
		return "ok";
	}
	
	@GetMapping(value = "/list")
	public List<Category> getListOfCategory() {
		return repository.findAll();
	}
}
