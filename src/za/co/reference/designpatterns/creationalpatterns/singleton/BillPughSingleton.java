package za.co.reference.designpatterns.creationalpatterns.singleton;

public class BillPughSingleton{
	
	// Private constructor prevents instantiation from other classes
   private BillPughSingleton() {}
 
   /**
    * SingletonHolder is loaded on the first execution of Singleton.getInstance() 
    * or the first access to SingletonHolder.INSTANCE, not before.
    */
   private static class SingletonHolder { 
     private static final BillPughSingleton INSTANCE = new BillPughSingleton();
   }
 
   public static BillPughSingleton getInstance() {
     return SingletonHolder.INSTANCE;
   }


}
