package za.co.reference.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class CalculateTest {
	
	@BeforeClass
	public static void runBeforeClass(){
		Assert.assertNotNull("test");
	}
	
	@Before
	public void runBefore(){
		Assert.assertNotNull("test");
	}
	
	@Test
	public void test(){
		Calculate calculate = new Calculate();
//		Assert.assertEquals(15, calculate.multiply(4, 4));
		Assert.assertEquals("Result", 40, calculate.multiply(10, 5));
	}
	
	@Ignore
	public void ignoreThisTest(){
		Assert.assertNotNull("test");
	}
	
	@After
	public void runAfter(){
		Assert.assertNotNull("test");
	}
	
	@AfterClass
	public static void runAfterClass(){
		Assert.assertNotNull("test");
	}

}
