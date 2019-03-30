package za.co.reference.ejb3.titancruises.manytomanyuni;

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
public class Reservation{

	@Id
	@GeneratedValue
	private int id;
	@ManyToMany
	@JoinTable(name="reservationcabin",
		joinColumns={@JoinColumn(name="reservation")},
		inverseJoinColumns={@JoinColumn(name="cabin")}
	)
	private Set<Cabin> cabins = new HashSet<Cabin>();
	
}