package dmst.seip.angor.junit_class_demo.grades;

public class HistogramMain {

	public static void main(String[] args) {
		HistogramGenerator hg = new HistogramGenerator(new FileUtility());
		hg.generateHistogram("grades.txt", "histogram.jpeg");
		
		System.out.println("Program terminated");
	}

}
