package za.co.reference.practice.ejb.session;

import java.util.List;
import za.co.reference.ejb3.entity.Member;

public interface TestInterface{
	
	public Member addMemder(Member member);
	
	public Member changeMember(Member member);
	
	public void removeMember(Member member);
	
	public Member getMember(Member member);
	
	public List listMembers();

}
