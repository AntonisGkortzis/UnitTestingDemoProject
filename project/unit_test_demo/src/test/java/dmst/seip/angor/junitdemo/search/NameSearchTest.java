package dmst.seip.angor.junitdemo.search;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;

import dmst.seip.angor.junitdemo.io.FileIO;

public class NameSearchTest {
	
	
	@Test
	public void testFindNamesInFileThatStartWith() {
		FileIO fileio = mock(FileIO.class);
		
		String path = "src/test/resources/names_valid.txt";
		when(fileio.readFile(path)).thenReturn(new String[] {"Mitch","Chris","John","Carol"});
		
		NameSearch ns = new NameSearch();
		String[] expected = {"Chris","Carol"};
		String[] actual = ns.findNamesInFileThatStartWith(path, fileio, "C");
		
		assertArrayEquals(expected, actual);
	}
	
}
