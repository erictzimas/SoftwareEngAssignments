package gr.dmst;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/***
 * 
 * @author erictzimas 
 * 
 * @since April 2021 
 */
public class Main {
	public static void main(String[] args) throws IOException {
        // TODO code application logic here
		// This if statement is used in case the user doesn't provide path argument
		if (args.length == 0) {
			System.out.println("Please provide a path for the file");
		} else {
		System.out.print("Generating histogram...");
        // Get filename from user
        String path = args[0];
        // create token1
        String token1 = "";
        // Creating list to store argument 
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
        // Catch exception incase path is not found
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
  }

