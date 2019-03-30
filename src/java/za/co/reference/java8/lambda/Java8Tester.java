package za.co.reference.java8.lambda;

/**
 * https://www.tutorialspoint.com/java8/java8_lambda_expressions.htm
 * 
 * @author Jaco Koekemoer
 * Date: 2017-06-07
 *
 */
public class Java8Tester
{

	public static void main(String[] args)
	{
		Java8Tester tester = new Java8Tester();
		
		//with type declaration
		MathOperation addition = (int a, int b) -> a + b;
		
		System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
		System.out.println("10 + 5 = " + addition.operation(5, 10));
		
		GreetingService greeting1 = (message) -> System.out.println(message);
		greeting1.sayMessage("Hello world");
		
	}
	
	private int operate(int a, int b, MathOperation mathOperation)
	{
		return mathOperation.operation(a, b);
	}
	
}
