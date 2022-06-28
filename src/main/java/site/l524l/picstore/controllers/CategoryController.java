package site.l524l.picstore.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
	
	@PreAuthorize("hasAuthority('CATEGORY_ADMIN')")
	@PostMapping(value = "/add")
	public ResponseEntity<?> addCategory(@RequestBody Category category) {
		if (repository.existsById(category.getName())) {
			return ResponseEntity.ok("Category already exist!");
		}
		
		repository.save(category);
	
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "/remove")
	public ResponseEntity<?> removeCategory(@RequestParam String name) {
		repository.deleteById(name);
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping(value = "/change")
	public ResponseEntity<?> changeCategory(@RequestBody Category category) {
		if (repository.existsById(category.getName()) == false) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Category doesn't exist!");
		}
		
		repository.save(category);
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "/list")
	public ResponseEntity<?> getListOfCategory() {
		return ResponseEntity.ok(repository.findAll());
	}
}
