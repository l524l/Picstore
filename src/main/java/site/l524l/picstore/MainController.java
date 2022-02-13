package site.l524l.picstore;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public @ResponseBody String test() {
		return "<h1>ок</h1>";
	}
	
	@RequestMapping(path = "/upload", method = RequestMethod.POST)
	public @ResponseBody String upload(@RequestParam("category") String name, @RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			String filename = file.getOriginalFilename();
			int dot = filename.lastIndexOf(".");
			
			File file2 = new File("E:\\" + UUID.randomUUID() + filename.substring(dot));
			try {
				file.transferTo(file2);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "or";
        } else {
            return "Вам не удалось загрузить " + name + " потому что файл пустой.";
        }
	}
}