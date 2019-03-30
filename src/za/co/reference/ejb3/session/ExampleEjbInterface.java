package za.co.reference.ejb3.session;

import java.util.List;
import za.co.reference.ejb3.entity.Member;

/*
 * This interface is not specific to EJB
 */
public interface ExampleEjbInterface{
	
	public void methodOne();
	
	public void methodTwo(String paramaterOne);
	
	public Member addMember(Member member);
	
	public Member changeMember(Member member);
	
	public void removeMember(Member member);
	
	public List listMembers();
	
	public Member getMember(Member member);

}
