package math;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import math.MyMath;
import org.junit.Assert;
/**
 * A test class that implements a Parameterized test
 * for the MyMath factorial method, 
 * for demonstrating Unit Testing.
 * @author erictzimas 
 */
@RunWith(Parameterized.class)
public class MyMathParameterizedTest {
	/*
	 * Initializing 2 parameters
	 */
	@Parameter (value = 0)
	public int number;
	@Parameter (value = 1)
	public int result;
	MyMath mm = new MyMath();
	/*
	 * Method that generates the input values for 
	 * the tests
	 */
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{1,1},{2,2},{0,1},{12,479001600}};
		return Arrays.asList(data);
	}
	/*
	 * A unit test that is executed for each pair 
	 * of parameters
	 */
	@Test
	public void testFactorialCases() {
		Assert.assertEquals(result, mm.factorial(number));
	}

}
