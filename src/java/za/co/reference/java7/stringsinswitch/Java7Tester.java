package za.co.reference.java7.stringsinswitch;

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
		java7Tester.testStringInSwitch("Java 5");
	}
	
	public void testStringInSwitch(String param)
	{
		final String JAVA5 = "Java 5";
		final String JAVA6 = "Java 6";
		final String JAVA7 = "Java 7";
		
		switch(param)
		{
			case JAVA5:
				System.out.println(JAVA5);
				break;
			case JAVA6:
				System.out.println(JAVA6);
				break;
			case JAVA7:
				System.out.println(JAVA7);
				break;
			default:
				System.out.println("Unknown");
				break;
		}
	}

}
