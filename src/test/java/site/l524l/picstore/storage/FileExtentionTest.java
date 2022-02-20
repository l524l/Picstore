package site.l524l.picstore.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

public class FileExtentionTest {
	
	@Test
	void getExtentionStringTest() {		
		assertEquals(FileExtention.getExtention("test.test"), ".test");
		assertEquals(FileExtention.getExtention("test.asd.test"), ".test");
		assertEquals(FileExtention.getExtention("/asd/asd/asdasd"), null);
	}
	
	@Test
	void getExtentionPathTest() {
		Path p = Paths.get("/asd/asd/ssda.test");
		
		assertEquals(FileExtention.getExtention(p), ".test");
	}
	@Test
	void getExtentionFileTest() {
		File f = new File("/asd/asd/ssda.test");
		
		assertEquals(FileExtention.getExtention(f), ".test");
	}
}
