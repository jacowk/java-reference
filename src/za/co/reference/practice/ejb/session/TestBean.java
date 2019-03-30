package za.co.reference.practice.ejb.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import za.co.reference.ejb3.entity.Member;

@Stateless
public class TestBean implements TestRemote, TestLocal{

	@Override
	public Member addMemder(Member member){
		em.persist(member);
		return null;
	}

	@Override
	public Member changeMember(Member member){
		em.merge(member);
		return null;
	}

	@Override
	public void removeMember(Member member){
		em.remove(member);
	}

	@Override
	public Member getMember(Member member){
		em.find(Member.class, member);
		return null;
	}

	@Override
	public List listMembers(){
		em.createQuery("all from member").getResultList();
		return null;
	}
	
	@PersistenceContext(name = "test")
	EntityManager em;
	
	public static final String LocalJNDIName = TestBean.class.getSimpleName() + "/local";
	public static final String RemoteJNDIName = TestBean.class.getSimpleName() + "/remote";

}
