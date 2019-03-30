package za.co.reference.javaoracletutorial.methodlocalinner;

/**
 * This demonstrates method local inner classes, or a class declared inside of a method
 * 
 * https://www.tutorialspoint.com/java/java_innerclasses.htm
 * 
 * @author Jaco Koekemoer
 * Date: 2017-07-13
 *
 */
public class OuterClass {

	// instance method of the outer class
	
	void my_Method() {
		int num = 23;
		
		// method-local inner class
		class MethodInner_Demo {
			
			public void print() {
				System.out.println("This is a method inner class " + num);
			}
			
		} // end of inner class
		
		MethodInner_Demo inner = new MethodInner_Demo();
		inner.print();
	}
	
	public static void main(String[] args) {
		OuterClass outer = new OuterClass();
		outer.my_Method();
	}
	
}
