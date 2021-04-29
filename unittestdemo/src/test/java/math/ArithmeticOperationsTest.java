package math;
import org.junit.Assert;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import math.ArithmeticOperations;
import static org.mockito.Mockito.*;

/**
 * A class that provides Test Cases for 
 * the ArithmeticOperations Class
 * @author erictzimas
 */
public class ArithmeticOperationsTest {
	ArithmeticOperations mm = new ArithmeticOperations();
	/*
	 * A unit test that checks the case of division with 0
	 */
	@Test (expected = ArithmeticException.class)
	public void testZeroInputShouldCauseException() {
		mm.divide(2,0);
	}
	/*
	 * A unit test that checks a non-valid negative input
	 */
	@Rule
	public ExpectedException thrown = ExpectedException.none(); //initialize it to .none()
    @Test
	public void testMultiplyNegative_exception() {
    	thrown.expect(IllegalArgumentException.class);
    	thrown.expectMessage("x & y should be >= 0");
		mm.multiply(-2, 2);
	}
	/*
	 * A test case that checks an invalid input size
	 */
	@Rule
	public ExpectedException thrown2 = ExpectedException.none(); //initialize it to .none()

    @Test
	public void testMultiplyMaxInt_exception() {
    	thrown2.expect(IllegalArgumentException.class);
    	thrown2.expectMessage("The product does not fit in an Integer variable");
		mm.multiply(2000000, 2000000);
	}
}
