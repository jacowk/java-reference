package za.co.reference.javaoracletutorial.nestedclasses;

/**
 * 
 * @author Jaco Koekemoer
 * Date: 201-07-13
 *
 */
public class JavaTester {

	public static void main(String[] args) {
		OuterClass outerClass = new OuterClass();
		OuterClass.InnerClass innerClass = outerClass.new InnerClass();
		innerClass.test();
	}
	
}
