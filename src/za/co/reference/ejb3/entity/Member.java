package za.co.reference.ejb3.entity;

import java.util.Collection;
import java.util.LinkedList;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@NamedQueries({
	@NamedQuery(name = "countMembersByContactNumber", query = "SELECT COUNT(b) FROM Member m WHERE " +
		"m.contactNumber = :contactNumber"),
	@NamedQuery(name = "countMembersByMemberReport", query = "SELECT COUNT(b) FROM Member m WHERE " +
		"m.memberReport = :m.memberReport")
})

/*
 * (Not EJB3 specific, but more to do with Annotations and Reflection) @BusinessIdentity can be exploited via reflection
 */
@BusinessIdentity(bidProperty = "code", nameProperties = {
		@NameProperty(property = "scheme"),
		@NameProperty(property = "code")
	}
)

/*
 * See how to properly implement @AssociationOverrides
 */
@AssociationOverrides({
	@AssociationOverride(name = "permittedGroups", joinColumns =
		@JoinColumn(name = "member"))
	}
)
@Table(name = "member")
@Entity
public class Member extends za.co.reference.ejb3.entity.Entity{

	public String getMemberNumber(){
		return memberNumber;
	}
	
	public void setMemberNumber(String memberNumber){
		this.memberNumber = memberNumber;
	}
	
	public Collection<Dependent> getDependants(){
		return dependants;
	}
	
	public void setDependants(Collection<Dependent> dependants){
		this.dependants = dependants;
	}
	
	public String getTransientField(){
		return transientField;
	}

	public void setTransientField(String transientField){
		this.transientField = transientField;
	}

	public MemberReport getMemberReport(){
		return memberReport;
	}

	public void setMemberReport(MemberReport memberReport){
		this.memberReport = memberReport;
	}

	public ContactNumber getContactNumber(){
		return contactNumber;
	}

	public void setContactNumber(ContactNumber contactNumber){
		this.contactNumber = contactNumber;
	}

	public Collection<ManyToManyExample> getManyToManyExamples(){
		return manyToManyExamples;
	}

	public void setManyToManyExamples(Collection<ManyToManyExample> manyToManyExamples){
		this.manyToManyExamples = manyToManyExamples;
	}

	public SampleEnumeration getSampleEnumeration(){
		return sampleEnumeration;
	}

	public void setSampleEnumeration(SampleEnumeration sampleEnumeration){
		this.sampleEnumeration = sampleEnumeration;
	}
	
	/*
	 * @AttachedAccessOnly is not EJB3 specific. More related to Annotations and Reflection
	 */
	@AttachedAccessOnly
	public String getAnAttachedAccessField(){
		return anAttachedAccessField;
	}

	public void setAnAttachedAccessField(String anAttachedAccessField){
		this.anAttachedAccessField = anAttachedAccessField;
	}

	private String memberNumber;
	
	/*
	 * Nothing in Dependent
	 */
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	@JoinColumn(name = "dependant")
	private Collection<Dependent> dependants;
	
	/*
	 * See entry in MemberReport
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "memberreport")
	private MemberReport memberReport;
	
	/*
	 * Nothing in ContactNumber
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "contactnumber")
	private ContactNumber contactNumber;
	
	/*
	 * Nothing in ManyToManyExample
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "membermanytomanyexample",
		joinColumns = {@JoinColumn(name = "member")},
		inverseJoinColumns = {@JoinColumn(name = "manytomanyexample")})
	private Collection<ManyToManyExample> manyToManyExamples = new LinkedList<ManyToManyExample>();
	
	private String anAttachedAccessField;
	@Enumerated(EnumType.STRING)
	private SampleEnumeration sampleEnumeration;
	@Transient
	private String transientField;
	@Lob
	private String lob;
	@Column(nullable = false)
	private String notNull;
	
}
