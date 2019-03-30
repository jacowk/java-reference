package za.co.reference.ejb2.cmp;

import javax.ejb.*;
import javax.naming.*;
import java.rmi.*;
import java.util.*;

/**
 * Client test application on a Container-Managed Entity Bean, Product.
 */
public class ProductClient {

    public static void main(String[] args) throws Exception {

        ProductHome home = null;

        try {
            /*
             * Get a reference to the Product Home Object - the
             * factory for Product EJB Objects
             */
            Context ctx = new InitialContext(System.getProperties());
            home = (ProductHome) javax.rmi.PortableRemoteObject.narrow(ctx.lookup("ProductHome"), ProductHome.class);

            /*
             * Use the factory to create the Product EJB Object
             */
            home.create("123-456-7890", "P5-350", "350 Mhz Pentium", 200);
            home.create("123-456-7891", "P5-400", "400 Mhz Pentium", 300);
            home.create("123-456-7892", "P5-450", "450 Mhz Pentium", 400);
            home.create("123-456-7893", "SD-64", "64 MB SDRAM", 50);
            home.create("123-456-7894", "SD-128", "128 MB SDRAM", 100);
            home.create("123-456-7895", "SD-256", "256 MB SDRAM", 200);

            /*
             * Find a Product, and print out it's description
             */
            Iterator i = home.findByName("SD-64").iterator();
            System.out.println("The following product descriptions match the product name SD-64:");
            while (i.hasNext()) {
                Product prod = (Product) javax.rmi.PortableRemoteObject.narrow(i.next(), Product.class);
                System.out.println(prod.getDescription());
            }

            /*
             * Find all products that cost $200
             */
            System.out.println("Calling finder to find all products that cost $200");
            i = home.findByBasePrice(200).iterator();

            while (i.hasNext()) {
                Product prod = (Product) javax.rmi.PortableRemoteObject.narrow(i.next(), Product.class);
                System.out.println(prod.getDescription());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (home != null) {
                System.out.println("Destroying products..");

                /*
                 * Find all the products
                 */
                Iterator i = home.findAllProducts().iterator();
                while (i.hasNext()) {
                    try {
                        Product prod = (Product) javax.rmi.PortableRemoteObject.narrow(i.next(), Product.class);
                        if (prod.getProductID().startsWith("123")) {
                            prod.remove();
                        }
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
