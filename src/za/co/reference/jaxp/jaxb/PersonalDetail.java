package za.co.reference.jaxp.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class PersonalDetail{
	
	public PersonalDetail(){
		
	}
	
	public PersonalDetail(String firstname, String surname){
		this.firstname = firstname;
		this.surname = surname;
	}
	
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
	
	@XmlAttribute(name="firstname")
	private String firstname;
	private String surname;

}
