package za.co.reference.javaoracletutorial.anonymousinner;

/**
 * Demonstrating an anonymous inner class
 * 
 * https://www.tutorialspoint.com/java/java_innerclasses.htm
 * 
 * @author Jaco Koekemoer
 * Date: 2017-07-13
 *
 */
public class OuterClass {

	public static void main(String[] args) {
		AnonymousInner inner = new AnonymousInner() {

			@Override
			public void mymethod() {
				System.out.println("This is an example of an anonymous inner class");
			}
			
		};
		inner.mymethod();
	}
	
}
