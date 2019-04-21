package dummy_maven_module;

import org.junit.Assert;
import org.junit.Test;

public class DummyClassTest {
	
	@Test
	public void testFoo() {
		DummyClass dc = new DummyClass();
		Assert.assertEquals(0, dc.foo());
	}

}
