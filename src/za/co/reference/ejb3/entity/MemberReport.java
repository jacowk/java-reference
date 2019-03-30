package za.co.reference.ejb3.entity;

import java.util.Collection;
import java.util.LinkedList;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "memberreport")
@javax.persistence.Entity
public class MemberReport extends za.co.reference.ejb3.entity.Entity{
	
	public Collection<Member> getMembers(){
		return members;
	}

	public void setMembers(Collection<Member> members){
		this.members = members;
	}

	@OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private Collection<Member> members = new LinkedList<Member>();

}
