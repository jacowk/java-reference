package za.co.reference.ejb3.titancruises.onetoonebi;

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
	
	//This is the owning side
	@Id
	@GeneratedValue
	private int id;
	/*
	 * @JoinColumn(name="creditCardId") specifies the name of the foreign key column in the relational 
	 * database
	 * 
	 * @OneToOne(mappedBy="creditCard") on the other side of the relationship specifies the name of the 
	 * attribute in the first part of the relationship
	 */
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="creditCardId")
	private CreditCard creditCard;

}