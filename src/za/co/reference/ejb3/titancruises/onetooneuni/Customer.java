package za.co.reference.ejb3.titancruises.onetooneuni;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer implements Serializable{

	public Address getAddress(){
		return address;
	}

	public void setAddress(Address address){
		this.address = address;
	}

	@Id
	@GeneratedValue
	private int id;
	/*
	 * JoinColumn defines the column in the Customer's table that references the primary key of the
	 * Address table. The "name" attribute specifies the name of the column in the Customer table.
	 */
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "address")
	private Address address;
	
}