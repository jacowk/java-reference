package za.co.reference.practice.comparator;

import java.util.Collections;
import java.util.List;

/*
 * Sorting by other fields
 */
public class TestEmployeeSort{
	
	public static void main(String[] args){
		List coll = Util.getEmployees();
		
		System.out.println("Employee name sort:");
		Collections.sort(coll, new EmpSortByName()); //Takes a Comparator as an argument
		printList(coll);
		
		System.out.println("\nEmployee ID sort:");
		Collections.sort(coll, new EmpSortByEmpId());
		printList(coll);
		
		System.out.println("\nEmployee age sort:");
		Collections.sort(coll, new EmpSortByAge());
		printList(coll);
	}
	
	private static void printList(List<Employee> list){
		System.out.println("EmpId\tName\tAge");
		for (Employee employee: list){
			System.out.println(employee.getEmpId() + "\t" + employee.getName() + "\t" + employee.getAge());
		}
	}

}

/*
 * 1. Sort employees using name, age, empId in this order (ie: when names are equal, try age and then next empId)
 * 2. Explore how & why equals() method and compare()/compareTo() methods must be consistence.
 */
