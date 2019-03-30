package za.co.reference.ejb2.bmp;

import java.util.Iterator;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

public class AccountClient{
	
	public static void main(String[] args){
		Account account = null;
		try{
			Context ctx = new InitialContext(System.getProperties());
			Object obj = ctx.lookup("AccountHome");
			AccountHome home = (AccountHome)PortableRemoteObject.narrow(obj, AccountHome.class);
			System.err.println("Total of all accounts in bank initially = " + home.getTotalBankValue());
			home.create("123-456-7890", "John Smith");
			
			Iterator i = home.findByOwnerName("John Smith").iterator();
			if (i.hasNext()){
				account = (Account)PortableRemoteObject.narrow(i.next(), Account.class);
			}
			else{
				throw new Exception("Could not find account");
			}
			
			System.out.println("Initial Balance = " + account.getBalance());
			account.deposit(100);
			
			System.out.println("After depositing 100, account balance = " + account.getBalance());
			System.out.println("Total of all accounts in bank now = " + home.getTotalBankValue());
			
			AccountPK pk = (AccountPK)account.getPrimaryKey();
			account = null;
			account = home.findByPrimaryKey(pk);
			
			System.out.println("Found account with ID " + pk + ".Balance = " + account.getBalance());
			
			System.out.println("Now trying to withdraw $150, which is more than is currently available." +
				" This should generate an exception..");
			account.withdraw(150);
			
		}
		catch (Exception e){
			System.out.println("Cuaght exception");
			e.printStackTrace();
		}
		finally{
			try{
				System.out.println("Destroying account");
				if (account != null){
					account.remove();
				}
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
	}

}
