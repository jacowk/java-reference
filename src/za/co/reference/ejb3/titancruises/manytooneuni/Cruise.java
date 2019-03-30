package za.co.reference.ejb3.titancruises.manytooneuni;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cruise")
public class Cruise implements Serializable{

	@Id
	@GeneratedValue
	private int id;
	/*
	 * The @JoinColumn annotation specifies that the Cruise entity's table has an additional column called 
	 * SHIP_ID that is a foreign key to the Ship entity's table.
	 * 
	 * If your persistence provider supports auto schema generation, you do not need to specify metadata like 
	 * @JoinColumn
	 * 
	 */
	@ManyToOne
	@JoinColumn(name="ship")
	private Ship ship;
	
}
