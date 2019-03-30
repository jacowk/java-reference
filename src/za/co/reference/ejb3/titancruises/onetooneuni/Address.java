package za.co.reference.ejb3.titancruises.onetooneuni;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address implements Serializable{
	
	@Id
	@GeneratedValue
	private int id;
	
}