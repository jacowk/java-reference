package za.co.reference.ejb3.titancruises.manytomanyuni;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cabin")
public class Cabin{
	
	@Id
	@GeneratedValue
	private int id;

}