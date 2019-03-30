package za.co.reference.ejb3.titancruises.manytomanybi;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation implements Serializable{

	@Id
	@GeneratedValue
	private int id;
	@ManyToMany
	@JoinTable(name="reservationcustomer",
		joinColumns={@JoinColumn(name="reservation")},
		inverseJoinColumns={@JoinColumn(name="customer")}
	)
	private Set<Customer> customers = new HashSet<Customer>();
	//A Set enforces uniqueness
	
	/*
	 * Reservation reservation = em.find(Reservation.class, id);
	 * reservation.getCustomers( ).remove(customer);
	 * 
	 */
	
}