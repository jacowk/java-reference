package za.co.reference.ejb3.session;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import za.co.reference.ejb3.entity.Member;

public class ExampleEjbBean implements ExampleEjbLocal, ExampleEjbRemote{

	@Override
	public void methodOne(){
		/* Using custom queries */
		Query query = entityManager.createQuery("select * from member m where m.someField = :someValue");
		query.setParameter("someValue", "a value");
		query.getResultList();
		
//		entityManager.createQuery("").getSingleResult();
		
		/* Using a Named Query */
		Query query1 = entityManager.createNamedQuery("queryOne"); //See named query in the Member class
		query1.setParameter("someValue", "a value");
		List result = query1.getResultList();
		
		//Another few examples
		String queryString = "SELECT e FROM NrplPublication r, IN (r.nrplTariffs) e WHERE r = :referrer AND e.code = :value";
//		String queryString = "SELECT r FROM NrplTariff r, IN (r.nrplPublication) e WHERE e = :referrer AND r.code = :value";
//		String queryString = "SELECT n FROM NrplTariff n WHERE n.nrplPublication = :referrer AND n.code = :value";
		
		Object referrer = new Object();
		String code = "001";
		query = entityManager.createQuery(queryString);
		query.setParameter("referrer", referrer);
		query.setParameter("value", code);
		List<Object> resultList = query.getResultList();
	}

	@Override
	public void methodTwo(String paramaterOne){
		
	}

	@Override
	public Member addMember(Member member){
		entityManager.persist(member);
		return null;
	}

	@Override
	public Member changeMember(Member member){
		entityManager.merge(member);
		return null;
	}

	@Override
	public void removeMember(Member member){
		entityManager.remove(member);
	}

	@Override
	public List listMembers(){
		return entityManager.createQuery("all from member").getResultList();
	}

	@Override
	public Member getMember(Member member){
		return entityManager.find(Member.class, member);
	}

	@PersistenceContext
	EntityManager entityManager;
	
	public static final String LocalJNDIName = ExampleEjbBean.class.getSimpleName() + "/local";
	public static final String RemoteJNDIName = ExampleEjbBean.class.getSimpleName() + "/remote";
	
}
