package dmst.seip.angor.junit_class_demo;

/**
 * An class that provides some "advanced" math operations
 * for demonstrating Unit Testing.
 * @author agkortzis (antonis.gkortzis@gmail.com)
 */
public class MyAdvancedMath {

	/**
	 * Adds two positive Integer
	 * @param x first positive Integer
	 * @param y second positive Integer 
	 * @return the results of the addition of the input Integers
	 * @exception IllegalArgumentException when one or 
	 * more input Integers are negative
	 * @exception IllegalArgumentException when the input Integers
	 * can cause an Integer overflow
	 */
	public int add(int x, int y) {
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException("Input numbers should be positive.");
		}

		if (y > Integer.MAX_VALUE - x) {
			throw new IllegalArgumentException("Cannot fit the result in an Integer.");
		}

		return x + y;
	}
	
	/**
	 * Calculates the power of two based on an input number.
	 * @param power the power of 
	 * @return the result
	 * @exception IllegalArgumentException when power is 
	 * larger than 30 or smaller than 0
	 */
	// TODO this method has only a Parameterized test. 
	// Can you complete the other edge tests?
	public int powerOfTwo(int power) {
		if (power == 0) {
			return 1;
		}
		// The case where the result doesn't fit in an Integer variable
		if (power <0 || power > 30) {
			throw new IllegalArgumentException("power should be 0<=power<=30");
		}
		
		int result = 1;
		for(int i=1; i<=power; i++) {
			result *= 2;
		}
		
		return result;
	}
	
	/**
	 * Reverses the signs of the elements in a given array. 
	 * The reverse for each element is performed by a given 
	 * MyMath instance
	 * @param array the input array of integers
	 * @param mm the MyMath instance
	 * @return an array with reversed signs
	 */
	public int[] reverseArray(int[] array, MyMath mm) {
		for(int i=0; i<array.length; i++) {
			array[i] = mm.reverseNumber(array[i]);
		}
		
		return array;
	}
		
}

