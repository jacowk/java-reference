package za.co.reference.ejb2.firstproject;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface HelloHome extends EJBHome{
	
	public Hello create() throws RemoteException, CreateException;

}
