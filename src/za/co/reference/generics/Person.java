package za.co.reference.generics;

public class Person{
	
	public String getFirstname(){
		return firstname;
	}
	
	public void setFirstname(String firstname){
		this.firstname = firstname;
	}
	
	public String getSurname(){
		return surname;
	}
	
	public void setSurname(String surname){
		this.surname = surname;
	}
	
	@Override
	public String toString(){
		return "I am a Person";
	}
	
	private String firstname;
	private String surname;

}
