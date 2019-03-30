package za.co.reference.ejb2.cmp;

import javax.ejb.*;

/**
 * These are the public business methods of ProductBean.
 *
 * This local interface is what local clients operate
 * on when they interact with our bean. The container
 * will implement this interface; the implemented object
 * is called the EJB local object, which delegates
 * invocations to instances of the entity bean class.
 */
public interface ProductLocal extends EJBLocalObject { 

    public String getName();
    public void setName(String name);
    
    public String getDescription();
    public void setDescription(String description);
    
    public double getBasePrice();
    public void setBasePrice(double price);
    
    public String getProductID();
} 
