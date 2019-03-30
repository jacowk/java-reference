package za.co.reference.practice.equalshashcode.example1;

/*
 * In this example equals() and hashCode() are overriden, because we want to compare two objects using the 
 * equals() method
 */
public class HashTest{
	
	public static void main(String[] args){
		Employee employee = new Employee(23);
		System.out.println("Overridden hashCode: " + employee.hashCode());
		System.out.println("Original hashCode: " + System.identityHashCode(employee));
		
		Employee employee2 = new Employee(23);
		System.out.println("employee.equals(employee2) = " + employee.equals(employee2));
	}

}
