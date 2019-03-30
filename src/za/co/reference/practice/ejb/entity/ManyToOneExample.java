package za.co.reference.practice.ejb.entity;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "manytooneexample")
@javax.persistence.Entity
public class ManyToOneExample extends Entity{
	
	@OneToMany(mappedBy = "testejb", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<TestEJB> testEjbs;

}
