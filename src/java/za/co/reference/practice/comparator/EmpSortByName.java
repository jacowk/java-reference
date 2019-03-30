package za.co.reference.practice.comparator;

import java.util.Comparator;

public class EmpSortByName implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2){
		//Using the String class's compareTo to compare the strings
		return e1.getName().compareTo(e2.getName());
	}

}
