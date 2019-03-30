package za.co.reference.io.objectstreams;

import java.io.Serializable;

public class Person implements Serializable{

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
	
	private String firstname;
	private String surname;
	
}