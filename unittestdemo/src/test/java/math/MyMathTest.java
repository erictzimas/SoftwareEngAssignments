package math;
import org.junit.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import math.MyMath;
/**
 * A class that provides Test Cases for 
 * the MyMath Class
 * @author erictzimas
 */
public class MyMathTest {
	MyMath mm = new MyMath();
	/*
	 * A test case that checks an invalid negative input
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFactorialNegativeException() {
		mm.factorial(-1);
	}
	/*
	 * A test case that checks an invalid input ,greater than 12
	 */
	@Test(expected = IllegalArgumentException.class)
    public void testFactorialShouldCauseAnException() {
		mm.factorial(13);
	}
	/*
	 * A test case that checks the functionality of factorial() with 
	 * valid input
	 */
	@Test
	public void testFactorialShouldReturnSix() {
		Assert.assertEquals(6, mm.factorial(3));
	}
	/*
	 * A test case that checks the functionality of isPrime() with 
	 * input < 2
	 */
	@Rule
	public ExpectedException thrown = ExpectedException.none(); //initialize it to .none()
	@Test
	public void testisPrimeShouldCauseException() {
		thrown.expect(IllegalArgumentException.class);
    	thrown.expectMessage("Input number must me >= 2");
		mm.isPrime(1);
	}
	/*
	 * A test case that checks the functionality of isPrime() with 
	 * a valid prime number as input
	 */
	@Test
	public void testisPrimeShouldReturnTrue() {
		mm.isPrime(7);
	}
	/*
	 * A test case that checks the functionality of isPrime() with
	 * a valid non-prime input
	 */
	@Test 
	public void testisPrimeShouldReturnFalse() {
		mm.isPrime(2);
	}


}
