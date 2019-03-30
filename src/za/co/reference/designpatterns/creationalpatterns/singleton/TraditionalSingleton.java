package za.co.reference.designpatterns.creationalpatterns.singleton;

public class TraditionalSingleton{
	
	private static final TraditionalSingleton INSTANCE = new TraditionalSingleton();
	 
   // Private constructor prevents instantiation from other classes
   private TraditionalSingleton() {}
 
   public static TraditionalSingleton getInstance() {
      return INSTANCE;
   }

}
