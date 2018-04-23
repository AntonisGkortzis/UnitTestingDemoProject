package dmst.seip.angor.junit_class_demo;

/**
 * An class that provides some "simple" math operations
 * for demonstrating Unit Testing.
 * @author agkortzis (antonis.gkortzis@gmail.com)
 */
public class MyMath 
{
	/**
	 * Receives an Integer number and returns its sign in the form of 
	 * "positive" or "negative. Zeros cause an {@link IllegalArgumentException} 
	 * @param number the integer input number
	 * @return 
	 * A String value with the input number's sign
	 * @exception IllegalArgumentException when input is 0
	 */
	public String checkSign(int number) {
		if ( number > 0 ) {
			return "positive";
		} else if ( number < 0 ) {
			return "negative";
		} else {
			throw new IllegalArgumentException("Number had no sign");
		}
	}
	
	/**
	 * Reverses the sign of a given number
	 * @param number the input number 
	 * @return a number with reversed sign
	 */
	public int reverseNumber(int number) {
		return -number;
	}
	
}

