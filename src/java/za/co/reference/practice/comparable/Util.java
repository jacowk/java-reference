package za.co.reference.practice.comparable;

import java.util.ArrayList;
import java.util.List;

public class Util{
	
	public static List<Employee> getEmployees(){
		List<Employee> col = new ArrayList<Employee>();
		col.add(new Employee(5, "Frank", 29));
		col.add(new Employee(1, "Jorge", 19));
		col.add(new Employee(6, "Bill", 34));
		col.add(new Employee(3, "Michel", 10));
		col.add(new Employee(7, "Simpson", 8));
		col.add(new Employee(4, "Clerk",16 ));
		col.add(new Employee(8, "Lee", 40));
		col.add(new Employee(2, "Mark", 30));
		return col;
	}

}
