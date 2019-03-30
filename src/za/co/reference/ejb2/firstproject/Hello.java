package za.co.reference.ejb2.firstproject;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface Hello extends EJBObject{
	
	public String hello() throws RemoteException;

}
