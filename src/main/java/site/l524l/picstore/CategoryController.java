package site.l524l.picstore;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import site.l524l.picstore.category.Category;
import site.l524l.picstore.category.CategoryRepository;

@Controller
public class CategoryController {

	private final CategoryRepository repository;
	
	
	public CategoryController(CategoryRepository repository) {
		this.repository = repository;
	}
	
	
	@GetMapping(value = "/category/add")
	public @ResponseBody String addCategory(@RequestBody Category category) {
		if (repository.existsById(category.getName())) {
			return "Category already exist!";
		}
		
		repository.save(category);
	
		return "ok";
	}
	
	@GetMapping(value = "/category/remove")
	public @ResponseBody String removeCategory(@RequestParam String name) {
		repository.deleteById(name);
		
		return "ok";
	}
	
	@GetMapping(value = "/category/change")
	public @ResponseBody String changeCategory(@RequestBody Category category) {
		if (repository.existsById(category.getName()) == false) {
			return "Category doesn't exist!";
		}
		
		repository.save(category);
		
		return "ok";
	}
	
	@GetMapping(value = "/category/list")
	public @ResponseBody List<Category> getListOfCategory() {
		return repository.findAll();
	}
}
