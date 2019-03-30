package za.co.reference.ejb3.titancruises.onetomanyuni;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer implements Serializable{

	/*
	 * The @JoinColumn annotation references the CUSTOMER_ID column in the PHONE table
	 */
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="customer")
	private Collection<Phone> phoneNumbers = new LinkedList<Phone>();
	/*
	 * The joinColumns( ) attribute should define a foreign key mapping to the primary key of the owning side 
	 * of the relationship. The inverseJoinColumns( ) attribute maps the nonowning side. If either side of the 
	 * relationship had a composite primary key, we would just add more @JoinColumn annotations to the array
	 */
	@OneToMany(cascade={CascadeType.ALL})
	@JoinTable(name="CustomerPhone",
		joinColumns={@JoinColumn(name="customerId")},
		inverseJoinColumns={@JoinColumn(name="phone")})
	private Collection<Phone> morePhoneNumbers = new LinkedList<Phone>();
	
}