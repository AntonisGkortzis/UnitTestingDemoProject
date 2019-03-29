package dmst.seip.angor.junit_class_demo;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.*;

/**
 * An class that provides test cases for the 
 * "advanced" math operations of the MyAdvancedMath 
 * class, for demonstrating Unit Testing.
 * @author agkortzis (antonis.gkortzis@gmail.com)
 */
public class MyAdvancedMathTest {
	/* 
	 * A reference to the MyAdvancedMath class
	 * whose methods we are testing in this class
	 */
	MyAdvancedMath mam ;
	
	/*
	 * This is a constructor which is called 
	 * when the MyAdvancedMathTest
	 */
	public MyAdvancedMathTest() {
		this.mam = new MyAdvancedMath();
	}
	
	/*
	 * A test case that examines the add method
	 * with normal input values. 
	 */
	@Test
	public void test_add_normal() {
		Assert.assertEquals(7, mam.add(5, 2));
	}
	
	/*
	 * A test case that examines the add method
	 * with zeros input values. 
	 */
	@Test
	public void testAdd_shouldReturnZero() {
		Assert.assertEquals(0, mam.add(0, 0));
	}
	
	/*
	 * A test case for the exceptions caused when
	 * the result of the addition doesn't fit 
	 * in an Integer variable.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testAdd_shouldThrowException_overflow() {
		mam.add(Integer.MAX_VALUE, 1);
	}
	
	/*
	 * A test case for the exceptions caused when
	 * one or more input values are negative. Testing
	 * the exception is performed with a @Rule
	 */
	@Rule 
	public ExpectedException thrown = ExpectedException.none(); //initialize it to .none()
	@Test 
	public void testAdd_shouldThrowException_negativeInput() {
		// With @Rules you can perform more sophisticated checks
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input numbers should be positive.");
		mam.add(-5, 1);
		
	}
		
	/*
	 *  The following method aims to test the reverseArray 
	 *  of the MyAdvancedMath class. However, its execution 
	 *  depends on the MyMath's reverseNumber method and a fail 
	 *  in this method can cause this test to fail too. Thus, the 
	 *  test is not isolated and cannot be called a valid Unit Test.
	 *  The test_reverseArray_Mocking() is the atomic and 
	 *  isolated unit test for the reverseArray method.
	 */
	@Test
	public void test_reverseArray() {
		MyMath mm = new MyMath();
		int[] testValues = {1,2,-3,-4};
		Assert.assertArrayEquals(new int[]{-1,-2,3,4}, 
				mam.reverseArray(testValues, mm));
	}
	
	/*
	 * The following test aims to fix the problem described in 
	 * the previous test_reverseArray test case. In order to 
	 * isolate the external (to this class) dependencies (MyMath)
	 * we have to mock them and predefine the results of
	 * all calls that we plan to execute on the MyMaths' methods.
	 */
	@Test
	public void test_reverseArray_Mocking() {
		// Mock the MyMath dependency
		MyMath mm = mock(MyMath.class);
		// Pre-define the results of the reverseNumber calls
		when(mm.reverseNumber(1)).thenReturn(-1);
		when(mm.reverseNumber(2)).thenReturn(-2);
		when(mm.reverseNumber(-3)).thenReturn(3);
		when(mm.reverseNumber(-4)).thenReturn(4);
		
		int[] testValues = {1,2,-3,-4};
		// Call the reverseArray with the mocked MyMath instance
		Assert.assertArrayEquals(new int[]{-1,-2,3,4}, 
				mam.reverseArray(testValues, mm));
	}
	

}
