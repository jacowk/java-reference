package za.co.reference.practice.equalshashcode.example2;

import java.util.HashSet;

/*
 * In this example equals() and hashCode() are overriden, because we store objects in a HashMap
 * Try running this after commenting out the overridden hashCode() and equals() methods in the Employee class,
 * then notice the size of the HashSet before and after running the program.
 */
public class HashTest{
	
	public static void main(String[] args){
		Employee e1 = new Employee(23);
		Employee e2 = new Employee(24);
		Employee e3 = new Employee(25);
		Employee e4 = new Employee(26);
		Employee e5 = new Employee(27);
		HashSet<Employee> hashSet = new HashSet<Employee>();
		hashSet.add(e1);
		hashSet.add(e2);
		hashSet.add(e3);
		hashSet.add(e4);
		hashSet.add(e5);
		System.out.println("HashSet size: " + hashSet.size());
		System.out.println("hashSet.contains(new Employee(25)): " + hashSet.contains(new Employee(25)));
		System.out.println("hashSet.remove(new Employee(24)): " + hashSet.remove(new Employee(24)));
		System.out.println("New HashSet size: " + hashSet.size());
	}
	
}
