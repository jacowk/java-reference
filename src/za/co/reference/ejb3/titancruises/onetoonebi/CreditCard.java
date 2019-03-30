package za.co.reference.ejb3.titancruises.onetoonebi;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="creditcard")
public class CreditCard implements Serializable{
	
	//This is the non owning side
	@Id
	@GeneratedValue
	private int id;
	private Date expiration;
	private String number;
	private String name;
	private String organization;
	/*
	 * mappedBy: This attribute sets up the bidirectional relationship and tells the persistence manager that 
	 * the information for mapping this relationship to our tables is specified in the Customer bean class, 
	 * specifically to the creditCard property of Customer.
	 * 
	 * SessionBean:
	 * ------------
	 * Customer cust = new Customer( );
	 * CreditCard card = new CreditCard( );
	 * cust.setCreditCard(card);
	 * card.setCustomer(cust);
	 * entityManager.persist(cust);
	 * 
	 */
	@OneToOne(mappedBy="creditCard")
	private Customer customer;

}