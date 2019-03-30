package za.co.reference.ejb3.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "contactnumber")
@Entity
public class ContactNumber extends za.co.reference.ejb3.entity.Entity{
	
	public String getContactNumber(){
		return contactNumber;
	}

	public void setContactNumber(String contactNumber){
		this.contactNumber = contactNumber;
	}

	private String contactNumber;

}
