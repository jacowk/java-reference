package za.co.reference.ejb2.bmp;

import java.rmi.RemoteException;

import javax.ejb.EJBLocalObject;
import javax.security.auth.login.AccountException;

public interface AccountLocal extends EJBLocalObject{
	
public void deposit(double amt) throws AccountException;
	
	public void withdraw(double amt) throws AccountException;
	
	public double getBalance();
	
	public String getOwnerName();
	
	public void setOwnerName(String name);
	
	public String getAccountID();
	
	public void setAccountID(String id);

}
