package za.co.reference.ejb2.cmp;

import javax.ejb.*;
import java.rmi.RemoteException;
import java.util.Collection;

/**
 * This is the home interface for Product.  This interface
 * is implemented by the EJB Server's glue-code tools.
 * The implemented object is called the Home Object, and
 * serves as a factory for EJB Objects.
 * 
 * One create() method is in this Home Interface, which
 * corresponds to the ejbCreate() method in the Product file.
 */
public interface ProductHome extends EJBHome {

    /*
     * Creates a product
     *
     * @param productID The number of the product (unique)
     * @param name The name of the product
     * @param description Product description
     * @param basePrice Base Price of product
     *
     * @return The newly created EJB Object.
     */
    Product create(String productID, String name, String description, double basePrice) 
        throws CreateException, RemoteException;

    // Finder methods.  These are implemented by the
    // container.  You can customize the functionality of
    // these methods by using the EJB Container tools.

    public Product findByPrimaryKey(String key) throws FinderException, RemoteException;

    public Collection findByName(String name) throws FinderException, RemoteException;

    public Collection findByDescription(String description) throws FinderException, RemoteException;

    public Collection findByBasePrice(double basePrice) throws FinderException, RemoteException;

    public Collection findExpensiveProducts(double minPrice) throws FinderException, RemoteException;

    public Collection findCheapProducts(double maxPrice) throws FinderException, RemoteException;

    public Collection findAllProducts() throws FinderException, RemoteException;
}
