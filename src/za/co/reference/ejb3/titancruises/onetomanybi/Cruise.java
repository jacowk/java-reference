package za.co.reference.ejb3.titancruises.onetomanybi;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cruise")
public class Cruise implements Serializable{

	@Id
	@GeneratedValue
	private int id;
	@OneToMany(mappedBy="cruise")
	private Reservation reservation;
	
}
