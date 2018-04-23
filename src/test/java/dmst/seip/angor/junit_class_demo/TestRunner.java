package dmst.seip.angor.junit_class_demo;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * An class with a main method for executing the defined 
 * classes that include tests and presenting the results, 
 * for demonstrating Unit Testing.
 * @author agkortzis (antonis.gkortzis@gmail.com)
 */
public class TestRunner {

	public static void main(String[] args) {
		/*
		 * The JUnitCore can execute a set of
		 * classes that include tests by calling 
		 * the static runClasses method with the 
		 * test classes as arguments. The results 
		 * are stored in a Result object that can 
		 * be parsed.
		 */
		Result result = JUnitCore.runClasses(
				MyMathTest.class,
				MyAdvancedMathTest.class,
				MyAdvancedMathTest_PowerOfTwo_Parameterized.class);
		
		// Retrieving and printing any failed tests
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.getMessage());
		}
		
		// Printing a success message (only if the execution was successful
		System.out.println("Tests completed successfully :: " 
		+ result.wasSuccessful());
	}

}
