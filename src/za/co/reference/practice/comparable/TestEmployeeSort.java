package za.co.reference.practice.comparable;

import java.util.Collections;
import java.util.List;

/*
 * Natural Sorting
 */
public class TestEmployeeSort{
	
	public static void main(String[] args){
		List coll = Util.getEmployees();
		Collections.sort(coll);
		printList(coll);
	}
	
	private static void printList(List<Employee> list){
		System.out.println("EmpId\tName\tAge");
		for (Employee employee: list){
			System.out.println(employee.getEmpId() + "\t" + employee.getName() + "\t" + employee.getAge());
		}
	}

}
