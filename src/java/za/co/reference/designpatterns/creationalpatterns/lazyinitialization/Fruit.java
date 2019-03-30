package za.co.reference.designpatterns.creationalpatterns.lazyinitialization;

import java.util.HashMap;
import java.util.Map;

public class Fruit{
	
	private static final Map<String,Fruit> types = new HashMap<String,Fruit>();
    private final String type;
 
    // using a private constructor to force use of the factory method.
    private Fruit(String type) {
      this.type = type;
    }
 
    /**
     * Lazy Factory method, gets the Fruit instance associated with a
     * certain type. Instantiates new ones as needed.
     * @param type Any string that describes a fruit type, e.g. "apple"
     * @return The Fruit instance associated with that type.
     */
    public static synchronized Fruit getFruit(String type) {
      if(!types.containsKey(type))
      {
        types.put(type, new Fruit(type)); // Lazy initialization
      }
      return types.get(type);
    }

}
