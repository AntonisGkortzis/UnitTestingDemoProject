package dmst.seip.angor.junit_class_demo;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import org.junit.Assert;

/**
 * A test class that implements a Parameterized test
 * for the MyAdvancedMath powerOfTwo method, 
 * for demonstrating Unit Testing.
 * @author agkortzis (antonis.gkortzis@gmail.com)
 */
@RunWith(Parameterized.class)
public class MyAdvancedMathTest_PowerOfTwo_Parameterized {
	
	// the value is the id of each parameter
	@Parameter (value = 0) 
	public int power;
	@Parameter (value = 1) //Or just @Parameter(1)
	public int result;
	
	MyAdvancedMath mam = new MyAdvancedMath();
	
	/*
	 * The following method generates the input values 
	 * for the tests. 
	 */
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{2,4},{3,8},{4,16}};
		
		return Arrays.asList(data);
	}
	
	/*
	 * A unit test that is executed for each pair of 
	 * parameters. 
	 */
	@Test
	public void testPowerOfTwoWithNormalCases() {
		Assert.assertEquals(result, mam.powerOfTwo(power));
	}
	
	/*
	 * !! IMPORTANT !!
	 * It's not advised to add non-parameterized tests in 
	 * @RunWith(Parameterized.class) classes. They will be executed
	 * as many times as the existing pairs of parameters. 
	 * Normal unit tests should be placed in an other class.
	 */
}

