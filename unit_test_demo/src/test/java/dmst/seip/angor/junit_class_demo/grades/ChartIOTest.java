package dmst.seip.angor.junit_class_demo.grades;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Assert.*;

public class ChartIOTest {
	
	ChartIO io = new ChartIO();
	@Test
	public void test_readFile_happyPath() {
		String filepath = "src/test/resources/grades_normal.csv";
		
		int[] expected = new int[3];
		expected[0] = 15;
		expected[1] = 10;
		expected[2] = 0;
		
		Assert.assertArrayEquals(expected,io.readFile(filepath));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_readFile_SadPath() {
		io.readFile("asdasfdzad");
	}
	
	@Test (expected = NumberFormatException.class)
	public void test_readFile_invalidContent() {
		String filepath = "src/test/resources/grades_invalid.csv";
		io.readFile(filepath);
	}
}
