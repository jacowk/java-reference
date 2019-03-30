package za.co.reference.jaxp.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Person{
	
	public Person(){
		
	}
	
	public Person(PersonalDetail personalDetail){
		this.personalDetail = personalDetail;
	}

	public PersonalDetail getPersonalDetail(){
		return personalDetail;
	}

	public void setPersonalDetail(PersonalDetail personalDetail){
		this.personalDetail = personalDetail;
	}

	@XmlElement(name = "personalDetail")
	private PersonalDetail personalDetail;

}
