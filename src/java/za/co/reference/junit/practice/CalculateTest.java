package za.co.reference.junit.practice;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculateTest{
	
	@BeforeClass
	public static void testBeforeClass(){
		
	}
	
	@Before
	public void testBefore(){
		
	}
	
	@Test
	public void testCalculateMultiply(){
		Calculate calculate = new Calculate();
		Assert.assertEquals(15, calculate.multiply(4, 4));
	}
	
	@After
	public void testAfter(){
		
	}
	
	@AfterClass
	public static void testAfterClass(){
		
	}

}
