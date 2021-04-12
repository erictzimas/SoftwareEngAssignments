package gr.dmst;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
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
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that
		 * can be visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		/*
		 * The XYSeries that are loaded in the dataset. There might be many
		 * series in one dataset.
		 */
		XYSeries data = new XYSeries("random values");
		/*
		 * Populating the XYSeries data object from the input Integer array
		 * values.
		 */
		for (int i = 0; i < dataValues.length; i++) {
			data.add(i, dataValues[i]);
		}
		// add the series to the dataset
		dataset.addSeries(data);
		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls
		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Students grades histogram", "Students", "Grades", dataset,
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
	    // main method
	public static void main(String[] args) throws IOException {
        // TODO code application logic here
       
        // Getting filename from user
        String path = args[0];
        // create token1
        String token1 = "";
      
        // List<String> temps = new LinkedList<String>();
        List<String> temps = new ArrayList<String>();
        try {
        File file1 = new File(path);
        // create Scanner inFile1
		Scanner inFile1 = new Scanner(file1);
       
        // while loop to read file
        while (inFile1.hasNext()) {
          // find next line
          token1 = inFile1.nextLine();
          // adding file to list
          temps.add(token1);
          
        } } catch (FileNotFoundException e) {
        	e.printStackTrace();
        }
        // list to array
        String[] tempsArray = temps.toArray(new String[0]);
        int size = tempsArray.length;
        // string to int
        int [] arr = new int [size];
        for(int i=0; i<size; i++) {
           arr[i] = Integer.parseInt(tempsArray[i]);
        }
        // creating histogram
         HistogramGenerator demo = new HistogramGenerator();
		demo.generateChart(arr);
      }
}

