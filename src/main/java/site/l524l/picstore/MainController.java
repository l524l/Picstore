package site.l524l.picstore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/welcome")
	public @ResponseBody String test() {
		return "<h1>ок</h1>";
	}
}