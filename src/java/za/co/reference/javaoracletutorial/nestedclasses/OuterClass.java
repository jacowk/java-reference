package za.co.reference.javaoracletutorial.nestedclasses;

/**
 * Demonstrate how an inner class is created and instantiated
 * 
 * https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
 * 
 * @author Jaco Koekemoer
 * Date: 2017-07-13
 *
 */
public class OuterClass {
	
	public class InnerClass {
		
		public void test() {
			System.out.println("This is a method in the inner class");
		}
		
	}

}
