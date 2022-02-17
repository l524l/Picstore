package site.l524l.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import site.l524l.picstore.storage.FileExtention;

@SpringBootTest
public class FileExtentionTest {
	
	@Test
	void getExtentionStringTest() {		
		assertEquals(FileExtention.getExtention("test.test"), ".test");
		assertEquals(FileExtention.getExtention("test.asd.test"), ".test");
		//assertEquals(FileExtention.getExtention("/asd/asd/asdasd"), null);
		//assertEquals(FileExtention.getExtention("/asd/as.d/asdasd"), null);
	}
	
	@Test
	void getExtentionPathTest() {
		
	}
	@Test
	void getExtentionFileTest() {
		
	}
	
	
	
}
