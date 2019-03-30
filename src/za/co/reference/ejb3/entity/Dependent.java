package za.co.reference.ejb3.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "dependent")
@Entity
public class Dependent extends za.co.reference.ejb3.entity.Entity{
	
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
