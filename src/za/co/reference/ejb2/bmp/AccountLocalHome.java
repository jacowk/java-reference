package za.co.reference.ejb2.bmp;

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface AccountLocalHome extends EJBLocalHome{
	
	public Account create(String accountID, String ownerName) throws CreateException;
	
	public Account findByPrimaryKey(AccountPK key) throws FinderException;
	
	public Collection findByOwnerName(String name) throws FinderException;
	
	public double getTotalBankValue() throws AccountException;

}
