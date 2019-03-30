package za.co.reference.ejb3.titancruises.manytooneuni;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ship")
public class Ship implements Serializable{
	
	@Id
	@GeneratedValue
	private int id;
	
}