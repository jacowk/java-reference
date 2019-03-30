package za.co.reference.practice.comparator;

public class Employee implements Comparable<Employee>{
	
	public Employee(int empId, String name, int age){
		setEmpId(empId);
		setName(name);
		setAge(age);
	}
	
	public int getEmpId(){
		return empId;
	}
	
	public void setEmpId(int empId){
		this.empId = empId;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getAge(){
		return age;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	/**
     * Compare a given Employee with this object.
     * If employee id of this object is 
     * greater than the received object,
     * then this object is greater than the other.
     * 
     * If a collection of Employee objects is sorted using Collections.sort(List) method; sorting happens 
     * according to the ordering done inside this method.
     */
	@Override
	public int compareTo(Employee employee){
		return this.getEmpId() - employee.getEmpId();
	}

	private int empId;
	private String name;
	private int age;

}
