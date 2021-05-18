package math;
import math.MyMath;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.FileIO;
/**
 * A class that provides a function that iterates an array
 * of numbers and returns a new array that contains only its
 * prime numbers
 * @author erictzimas
 */
public class ArrayOperations {
	/*
	 * Method that returns array of only primes
	 */
	public int[] findPrimesIntFile(FileIO fileIo, String filepath, MyMath myMath) {
		MyMath mathi = new MyMath();
		File file = new File(filepath);
		if (!file.exists()) 
			throw new IllegalArgumentException("Input file does not exist");
		
		List<Integer> numbersList = new ArrayList<>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				try {
				   int number = Integer.parseInt(line);
				   if(mathi.isPrime(number)) {
				   numbersList.add(number);
				   }
				
				}catch(NumberFormatException e) {
					continue;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (numbersList.size() == 0) 
			throw new IllegalArgumentException("Given file is empty");
		
		// Convert a List to an array using 
		return numbersList.stream().mapToInt(i -> i).toArray();
	}

}
