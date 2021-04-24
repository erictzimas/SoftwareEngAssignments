package math;
/**
 * A class that provides a function that returns
 * the factorial of a given input number
 * @author erictzimas
 */
public class MyMath {
	/*
	 * Function that returns the factorial of an integer
	 */
	public int factorial(int n) {
		int i = 1;
		int fact = 1;
		if(n<0) {
			throw new IllegalArgumentException("Input numbers should be positive");
		} else if (n>12) {
			throw new IllegalArgumentException("Input should be less than 12");
		} else {
			
			for(i = 1; i <= n; i++) {
				fact = fact * i;
			}
		}
		return fact;
	}

}
