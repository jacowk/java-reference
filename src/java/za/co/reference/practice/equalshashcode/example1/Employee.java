package za.co.reference.practice.equalshashcode.example1;

public class Employee{
	
	public Employee(int age){
		setAge(age);
	}
	
	public int getAge(){
		return age;
	}

	public void setAge(int age){
		this.age = age;
	}
	
	public int hashCode(){
		return age;
	}
	
	public boolean equals(Object object){
		boolean flag = false;
		Employee employee = (Employee)object;
		if (employee.getAge() == this.getAge()){
			flag = true;
		}
		return flag;
	}

	private int age;

}
