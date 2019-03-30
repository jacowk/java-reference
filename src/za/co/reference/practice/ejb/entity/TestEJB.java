package za.co.reference.practice.ejb.entity;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name = "name1", query = "select stuff..."),
	@NamedQuery(name = "name2", query = "select stuff...")
})
@Table(name = "testejb")
@javax.persistence.Entity
public class TestEJB extends za.co.reference.practice.ejb.entity.Entity{
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "onetooneexample")
	private OneToOneExample oneToOneExample;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "onetomanyexample")
	private Collection<OneToManyExample> oneToManyExample;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manytooneexample")
	private ManyToOne manyToOneExample;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "testejbmanytomanyexample",
		joinColumns = {@JoinColumn(name = "ejbtest")},
		inverseJoinColumns = {@JoinColumn(name = "manytomanyexample")})
	private ManyToManyExample manyToManyExample;
	
}
