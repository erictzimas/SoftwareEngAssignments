package io;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import math.ArithmeticOperations;
import static org.mockito.Mockito.*;
import io.FileIO;
public class FileIOTest {
	FileIO fileio = new FileIO();
	public static String resourcesPath = "src/test/resources/";
	
	@Test
	public void testReadFileValidInput() {
		int[] expectedNumbers = new int[] {
				32,12,5,1,7
		};
		String validInputFilepath = 
			resourcesPath.concat("numbers_valid.txt");
		Assert.assertArrayEquals(expectedNumbers, fileio.readFile(validInputFilepath));
	}
	@Rule
	public ExpectedException thrown = ExpectedException.none(); //initialize it to .none()
	@Test
	public void testReadFileShouldReturnNoFileExists() {
		String nonvalidInputFilepath = 
				resourcesPath.concat("xxxx.txt");
    	thrown.expect(IllegalArgumentException.class);
    	thrown.expectMessage("Input file does not exist");
    	fileio.readFile(nonvalidInputFilepath);
	}
	@Rule
	public ExpectedException thrown2 = ExpectedException.none();
	@Test
	public void testReadFileShouldReturnEmptyException() {
		String emptyInputFilepath = 
				resourcesPath.concat("empty.txt");
		thrown2.expect(IllegalArgumentException.class);
		thrown2.expectMessage("Given file is empty");
		fileio.readFile(emptyInputFilepath);
	}
	@Test
	public void testReadFileContainsInvalidEntries() {
		int[] expectedNumbers = new int[] {
				1,2,3,4,5
		};
		String mixedinputFilepath = 
				resourcesPath.concat("numbers_mixed.txt");
		Assert.assertArrayEquals(expectedNumbers,fileio.readFile(mixedinputFilepath));
	}
}
