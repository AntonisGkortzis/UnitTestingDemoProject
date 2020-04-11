package dmst.seip.angor.junitdemo.io;

import org.junit.Assert;
import org.junit.Test;

public class FileIOTest {
	
	FileIO fileio = new FileIO();
	public static String resourcesPath = "src/test/resources/";
	
	@Test
	public void testReadFileValidInput() {
		String[] expectedNames = new String[] {
				"Mitch","Newmie","C.J","Matt","Caroline",
				"Jason","Lani","Summer","Logan"};
		String validInputFilepath = resourcesPath.concat("names_valid.txt");
		
		Assert.assertArrayEquals(expectedNames, fileio.readFile(validInputFilepath));
	}

}
