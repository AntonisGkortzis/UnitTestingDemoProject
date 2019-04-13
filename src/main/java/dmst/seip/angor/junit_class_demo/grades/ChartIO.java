package dmst.seip.angor.junit_class_demo.grades;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtils;

public class FileUtility {

	public int[] readFile(String filepath) {
		List<Integer> linesList = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				linesList.add(Integer.parseInt(line));
			}
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File " + filepath + " does not exist");
		} catch (IOException e) {
			throw new NumberFormatException();
		}

		int[] linesArray = new int[linesList.size()];
		for (int index = 0; index < linesList.size(); index++) {
			linesArray[index] = linesList.get(index);
		}

		return linesArray;
	}
	
	public void writeFile(String filepath, JFreeChart chart) {
		File output = new File(filepath); 
		try {
			ChartUtils.saveChartAsJPEG(output, chart, 500, 500);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	




}
