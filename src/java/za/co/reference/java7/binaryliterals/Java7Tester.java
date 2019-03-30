package za.co.reference.java7.binaryliterals;

/**
 * https://dzone.com/articles/new-java-7-language-features
 * 
 * @author JACO57
 *
 */
public class Java7Tester
{
	
	public static void main(String[] args)
	{
		Java7Tester java7Tester = new Java7Tester();
		java7Tester.testBinaryIntegralLiterals();
	}
	
	public void testBinaryIntegralLiterals()
	{
		int binary = 0b1000; //2^3 = 8
		
		if (binary == 8)
		{
			System.out.println(true);
		}
		else
		{
			System.out.println(false);
		}
	}

}
