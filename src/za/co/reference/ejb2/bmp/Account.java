package za.co.reference.ejb2.bmp;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import javax.security.auth.login.AccountException;

/*
 * Remote interface
 */
public interface Account extends EJBObject{
	
	public void deposit(double amt) throws AccountException, RemoteException;
	
	public void withdraw(double amt) throws AccountException, RemoteException;
	
	public double getBalance() throws RemoteException;
	
	public String getOwnerName() throws RemoteException;
	
	public void setOwnerName(String name) throws RemoteException;
	
	public String getAccountID() throws RemoteException;
	
	public void setAccountID(String id) throws RemoteException;

}
