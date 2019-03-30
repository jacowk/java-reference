package za.co.reference.ejb3.titancruises.onetomanyuni;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="phone")
public class Phone implements Serializable{

	@Id
	@GeneratedValue
	public int id;
	
}
