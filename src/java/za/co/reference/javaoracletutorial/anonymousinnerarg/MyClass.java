package za.co.reference.javaoracletutorial.anonymousinnerarg;

/**
 * Demonstrating anonymous inner class as argument
 * 
 * https://www.tutorialspoint.com/java/java_innerclasses.htm
 * 
 * @author Jaco Koekemoer
 * Date: 2017-07-13
 *
 */
public class MyClass {
	
	// method which accepts the object of interface Message
	public void displayMessage(Message m) {
		System.out.println(m.greet() + ", This is an example of anonymous inner class as an argument");
	}
	
	public static void main(String[] args) {
		// Instantiating the class
		MyClass obj = new MyClass();
		
		// Passing an anonymous inner class as an argument
		obj.displayMessage(new Message() {
			public String greet() {
				return "Hello";
			}
		});
	}

}
