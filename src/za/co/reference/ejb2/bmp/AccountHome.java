package za.co.reference.ejb2.bmp;

import java.rmi.RemoteException;
import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;

public interface AccountHome extends EJBHome{
	
	public Account create(String accountID, String ownerName) throws CreateException, RemoteException;
	
	public Account findByPrimaryKey(AccountPK key) throws FinderException, RemoteException;
	
	public Collection findByOwnerName(String name) throws FinderException, RemoteException;
	
	public double getTotalBankValue() throws AccountException, RemoteException;

}
