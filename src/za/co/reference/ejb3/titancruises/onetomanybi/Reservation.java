package za.co.reference.ejb3.titancruises.onetomanybi;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation implements Serializable{

	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	@JoinColumn(name="cruise")
	private Cruise cruise;
	
}
