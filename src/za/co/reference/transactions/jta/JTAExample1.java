package za.co.reference.transactions.jta;

import javax.ejb.EJBException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

public class JTAExample1{

	public static void main(String[] args){
		
	}
	
	public void withdrawCash(double amount) throws Exception{
		
		Context c = new InitialContext();
		//UserTransaction ut = context.getUserTransaction();
		//UserTransaction ut = (UserTransaction)c.lookup("javax.jts.UserTransaction");
		UserTransaction ut = (UserTransaction)c.lookup("java:comp/UserTransaction");

	   try {
	      ut.begin();
//	      updateChecking(amount);
//	      machineBalance -= amount;
//	      insertMachine(machineBalance);
	      ut.commit();
	   } catch (Exception ex) {
	       try {
	          ut.rollback();
	       } catch (SystemException syex) {
	           throw new EJBException
	              ("Rollback failed: " + syex.getMessage());
	       }
	       throw new EJBException 
	          ("Transaction failed: " + ex.getMessage());
	    }
	} 


}
