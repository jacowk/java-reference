package za.co.reference.ejb2.cmp;

import javax.ejb.*;
import java.rmi.RemoteException;

/**
 * These remote interface with public business methods of ProductBean.
 *
 * This interface is what remote clients operate on when they interact
 * with beans. The EJB Server vendor will implement this interface;
 * the implemented object instance is called the EJB Object, which
 * delegates invocations to instances of the ProductBean class.
 */
public interface Product 
    extends EJBObject 
{
    // Getter/setter methods for Entity Bean fields
    
    public String getName() throws RemoteException;
    public void setName(String name) throws RemoteException;
    
    public String getDescription() throws RemoteException;
    public void setDescription(String description) throws RemoteException;
    
    public double getBasePrice() throws RemoteException;
    public void setBasePrice(double price) throws RemoteException;
    
    public String getProductID() throws RemoteException;
}
