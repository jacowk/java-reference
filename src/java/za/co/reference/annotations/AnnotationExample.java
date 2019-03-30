package za.co.reference.annotations;


/*
 * http://www.roseindia.net/ejb/Annotations.shtml
 * Simple Annotations in JDK:
 * ==========================
 * Override
 * Depricated
 * Suppresswarnings
 * 
 * Meta Annotations in JDK:
 * ========================
 * Target: 
 * Retention: 
 * Documented: 
 * Inherited: 
 * 
 */
public class AnnotationExample{
	
	@MyAnnotation(outputStuff="Output Stuff")
	public void doSomething(){
		System.out.println("Do something");
	}

}
