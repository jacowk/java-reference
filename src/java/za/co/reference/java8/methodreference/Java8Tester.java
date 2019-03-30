package za.co.reference.java8.methodreference;

import java.util.ArrayList;
import java.util.List;

/**
 * Method references help to point to methods by their names. A method reference is described using :: (double colon) symbol. 
 * A method reference can be used to point the following types of methods:
	Static methods
	Instance methods
	Constructors using new operator (TreeSet::new)
 * 
 * 
 * @author jaco57
 *
 */
public class Java8Tester
{
	
	public static void main(String[] args)
	{
		List names = new ArrayList();
		names.add("John Doe");
		names.add("Jane Doe");
		names.add("Jack Doe");
		names.add("Jill Doe");
		
		names.forEach(System.out::println);
	}

}
