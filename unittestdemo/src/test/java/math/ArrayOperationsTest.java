package math;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import math.MyMath;
import io.FileIO;
import math.ArrayOperations;
import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.*;
/**
 * A class that provides Test Cases for 
 * the ArrayOperations Class
 * @author erictzimas
 */
public class ArrayOperationsTest {
	ArrayOperations pp = new ArrayOperations();
	public static String resourcesPath = "src/test/resources/";
	/*
	 * A test case that checks a valid input file with prime and non prime numbers
	 * with Mockito
	 */
	@Test
	public void testFindPrimesIntFileValidInput() {
		FileIO fileio = mock(FileIO.class);
		MyMath myMath = mock(MyMath.class);
		String path = 
				resourcesPath.concat("prime_numbers.txt");		
		when(fileio.readFile(path)).thenReturn(new int[] {2,3,4,5,6,7});
		
		ArrayOperations ao = new ArrayOperations();
		int[] expected = {2,3,5,7};
		int[] actual = ao.findPrimesIntFile(fileio, path, myMath);
		
		assertArrayEquals(expected, actual);	
	}
	/*
	 * A test case that checks an invalid input file that does not exist 
	 */
	@Rule
	public ExpectedException thrown = ExpectedException.none(); //initialize it to .none()
	@Test
	public void testFindPrimesShouldReturnNoFileExists() {
		FileIO fileio = mock(FileIO.class);
		MyMath myMath = mock(MyMath.class);
		String nonvalidInputFilepath = 
				resourcesPath.concat("filethatdoesntexist.txt");
    	thrown.expect(IllegalArgumentException.class);
    	thrown.expectMessage("Input file does not exist");
    	pp.findPrimesIntFile(fileio, nonvalidInputFilepath, myMath);
	}
	/*
	 * A test case that checks an invalid input file with size = 0
	 */
	@Rule
	public ExpectedException thrown2 = ExpectedException.none(); //initialize it to .none()
	@Test
	public void testFindPrimesShouldReturnEmptyFile() {
		FileIO fileio = mock(FileIO.class);
		MyMath myMath = mock(MyMath.class);
		String nonvalidInputFilepath = 
				resourcesPath.concat("empty.txt");
    	thrown2.expect(IllegalArgumentException.class);
    	thrown2.expectMessage("Given file is empty");
    	pp.findPrimesIntFile(fileio, nonvalidInputFilepath, myMath);
	}
}
