package dmst.seip.angor.junit_class_demo.grades;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class HistogramGenerator {
	private ChartIO utils; 
	
	public HistogramGenerator(ChartIO utils) {
		this.utils = utils;
	}
	
	public void generateHistogram(String gradesFilepath, String outputFilepath) {
		int[] grades = this.utils.readFile(gradesFilepath);
		int[] frequencies = calculateFrequencies(grades);
		JFreeChart histogram = createChart(frequencies);
		this.utils.writeFile(outputFilepath, histogram);
	}
	
	public int[] calculateFrequencies(int[] grades) {
		int[] frequencies = new int[11];
		
		for(Integer i : grades) {
			frequencies[i]++;
		}
		
		return frequencies;
	}
	
	public JFreeChart createChart(int[] frequencies) {
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that can be
		 * visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		/*
		 * The XYSeries that are loaded in the dataset. There might be many series in
		 * one dataset.
		 */
		XYSeries data = new XYSeries("random values");
		
		for (int i = 0; i < frequencies.length; i++) {
			data.add(i, frequencies[i]);
		}

		// add the series to the dataset
		dataset.addSeries(data);

		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Grades' Frequency", "grade", "frequency", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);
		
		return chart;
	}
	
	public void exportChart(String filepath, JFreeChart chart) {
		this.utils.writeFile(filepath, chart);
	}
	
	
	
}
