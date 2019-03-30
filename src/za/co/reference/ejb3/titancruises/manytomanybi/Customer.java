package za.co.reference.ejb3.titancruises.manytomanybi;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer implements Serializable{

	@Id
	@GeneratedValue
	private int id;
	@ManyToMany(mappedBy="customers")
	private Collection<Reservation> reservations = new LinkedList<Reservation>();
	
}