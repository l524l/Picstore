package site.l524l.picstore.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@GetMapping("/")
	public String test() {
		return "<h1>Aplication has run!</h1>";
	}
}