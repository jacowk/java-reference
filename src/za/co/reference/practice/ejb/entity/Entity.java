package za.co.reference.practice.ejb.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public class Entity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Version
	private long version;

}
