package za.co.reference.javaoracletutorial.staticnested;

/**
 * Demonstrating a static nested class
 * 
 * @author Jaco Koekemoer
 * Date: 2017-07-13
 *
 */
public class Outer {

	static class Nested_Demo {
		public void myMethod() {
			System.out.println("This is my nested class");
		}
	}
	
	public static void main(String[] args) {
		Outer.Nested_Demo nested = new Outer.Nested_Demo();
		nested.myMethod();
	}
	
}
