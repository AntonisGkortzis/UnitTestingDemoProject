package dmst.seip.angor.junit_class_demo.grades;

import org.junit.Test;
import static org.mockito.Mockito.*;

import org.jfree.chart.JFreeChart;

public class HistogramGeneratorTes {

	@Test
	public void test_generate_normal() {
		ChartIO io = mock(ChartIO.class);
		JFreeChart chart = mock(JFreeChart.class);
		when(io.readFile("")).thenReturn(new int[] {});
//		when(io.writeFile("", chart))
		HistogramGenerator hg = new HistogramGenerator(io);
		hg.generateHistogram("", "");
		verify(io, times(1)).readFile("");
		verify(io, times(1)).writeFile("",chart);
		verifyNoMoreInteractions(io);
		
		
	}
	
}
