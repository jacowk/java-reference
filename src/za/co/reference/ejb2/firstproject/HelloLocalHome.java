package za.co.reference.ejb2.firstproject;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

public interface HelloLocalHome extends EJBLocalHome{
	
	public HelloLocal create() throws CreateException;

}
