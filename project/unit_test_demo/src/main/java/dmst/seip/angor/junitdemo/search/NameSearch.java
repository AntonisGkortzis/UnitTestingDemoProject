package dmst.seip.angor.junitdemo.search;

import java.util.ArrayList;
import java.util.List;

import dmst.seip.angor.junitdemo.io.FileIO;

/**
 * Provides methods that search in Files
 *
 * @author agkortzis
 * @version 1.0
 * @since 2020-04-06
 */
public class NameSearch {
	
	/**
	 * Returns all matches in a file for names that start with a given prefix 
	 * @param filepath the file that contains a list of names
	 * @param fileIo the class that reads the file and returns an String[] with its contents
	 * @param prefix a sequence of characters 
	 * @return the array that contains the names that start with the prefix
	 */
	public String[] findNamesInFileThatStartWith(String filepath, FileIO fileIo, String prefix) {

		String[] names = fileIo.readFile(filepath);
		List<String> selectedNames = new ArrayList<>();

		for (String name : names) {
			if (name.startsWith(prefix))
				selectedNames.add(name);
		}

		return selectedNames.stream().toArray(String[]::new);
	}

}
