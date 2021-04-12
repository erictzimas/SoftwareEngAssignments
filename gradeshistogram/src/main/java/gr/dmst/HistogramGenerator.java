package gr.dmst;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
/***
 * 
 * @author erictzimas The purpose of this class is to create a JFreeChart XYLine chart 
 * from a given .txt file of students grades.
 * 
 * @since April 2021 
 */
public class HistogramGenerator {
	/***
	 * Receives a single dimension Integer array. From this array the dataset
	 * that will be used for the visualization is generated. Finally, The chart
	 * is generated with the use of the file input of the user and then
	 * presented in the screen.
	 * 
	 * @param dataValues Single dimension integer array
	 */
	public void generateChart(int[] dataValues) {
		//Create new HistogramDataset object to store the array of grades
		HistogramDataset dataset = new HistogramDataset();
		// Initialize array
		double [] grades = new double[dataValues.length];
		/*
		 * Populating the grades array from the input Integer array
		 * values.
		 */
		for (int i = 0; i < grades.length; i++) {
			grades[i] = dataValues[i];
		}
		// add the series to the dataset
		dataset.addSeries("Grades", grades, 10);
		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls
		// Declare and initialize a Histogram JFreeChart
		JFreeChart chart = ChartFactory.createHistogram("Students grades Histogram", "Grade Score", "Number of Students", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);
		/*
		 * Initialize a frame for visualizing the chart and attach the
		 * previously created chart.
		 */
		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
	}	
}

