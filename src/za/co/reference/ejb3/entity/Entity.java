package za.co.reference.ejb3.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class Entity{
	
	public Long getOid(){
		return oid;
	}

	public void setOid(Long oid){
		this.oid = oid;
	}

	public Long getVersion(){
		return version;
	}

	public void setVersion(Long version){
		this.version = version;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long oid;
	
	@Version
	private Long version;

}
