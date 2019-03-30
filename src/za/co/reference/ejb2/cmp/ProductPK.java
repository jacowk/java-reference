package za.co.reference.ejb2.cmp;

import java.io.Serializable;

/**
 * Primary Key class for our 'Product' Container-Managed
 * Entity Bean
 */
public class ProductPK implements java.io.Serializable {

    /*
     * Note that the primary key fields must be a
     * subset of the the container-managed Bean fields.
     * The fields we are marking as container-managed in
     * our Bean are productID, name, desc, and basePrice.
     * Therefore our PK fields need to be from that set.
     */
    public String productID;

    public ProductPK(String productID) {
        this.productID = productID;
    }

    public ProductPK() {
    }

    public String toString() {
        return productID.toString();
    }

    public int hashCode()
    {
        return productID.hashCode();
    }

    public boolean equals(Object prod)
    {
        return ((ProductPK)prod).productID.equals(productID);
    }  
}
