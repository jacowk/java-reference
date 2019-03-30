package za.co.reference.ejb2.firstproject;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class HelloBean implements SessionBean{

	@Override
	public void ejbActivate() throws EJBException, RemoteException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ejbPassivate() throws EJBException, RemoteException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ejbRemove() throws EJBException, RemoteException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSessionContext(SessionContext arg0) throws EJBException, RemoteException{
		// TODO Auto-generated method stub
		
	}
	
	public void ejbCreate(){
		
	}
	
	public String hello(){
		System.out.println("hello()");
		return "Hello, World!";
	}

}
