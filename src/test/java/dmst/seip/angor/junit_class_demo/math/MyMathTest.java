package dmst.seip.angor.junit_class_demo;

import org.junit.Test;
import org.junit.Assert;

/**
 * An class that provides test cases for the 
 * "simple" math operations of the MyMath 
 * class, for demonstrating Unit Testing.
 * @author agkortzis (antonis.gkortzis@gmail.com)
 */
public class MyMathTest {
	MyMath mm = new MyMath();
	
	/*
	 * A unit test that checks a valid positive input
	 */
    @Test
    public void testGetSignShouldReturnPositive() {
    	Assert.assertEquals("positive", mm.checkSign(3));
    }
    
    /*
	 * A unit test that checks a valid negative input
	 */
    @Test
    public void testGetSignShouldReturnNegative() {
    	Assert.assertEquals("negative", mm.checkSign(-3));
    }
    
    /*
	 * A unit test that checks an invalid zero input
	 * that causes an IllegalArgumentException
	 */
    @Test (expected = IllegalArgumentException.class)
    public void testGetSignShouldCauseAnException() {
    	mm.checkSign(0);
    }  
    
    /*
     * A unit test that checks a valid positive input and
     * expects its opposite as a result
     */
    @Test
    public void testReverseNumberShouldReturnNegative() {
    	Assert.assertEquals(-5, mm.reverseNumber(5));
    }
    
    /*
     * A unit test that checks a valid negative input and
     * expects its opposite as a result
     */
    @Test
    public void testReverseNumberShouldReturnPositive() {
    	Assert.assertEquals(3, mm.reverseNumber(-3));
    }
    
    /*
     * A unit test that checks a valid zero input and
     * expects a zero as a result
     */
    @Test
    public void testReverseNumberShouldReturnZero() {
    	Assert.assertEquals(0, mm.reverseNumber(0));
    }
}



