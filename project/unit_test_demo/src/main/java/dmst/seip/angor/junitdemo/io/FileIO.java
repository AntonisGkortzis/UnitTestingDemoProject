package dmst.seip.angor.junitdemo.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* Provides simple file input/output operations
* that serve as hands-on practice on Unit Testing.
*
* @author  agkortzis
* @version 1.0
* @since   2020-04-06 
*/
public class FileIO {
	
	/**
	 * Reads a file and returns its content in an String[] array 
	 * @param filepath the file that contains text in lines
	 * @return an array with the file content
	 */
	public String[] readFile(String filepath) {
		File file = new File(filepath);
		
		List<String> names = new ArrayList<>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				names.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return names.stream().toArray(String[]::new);
	}
}
