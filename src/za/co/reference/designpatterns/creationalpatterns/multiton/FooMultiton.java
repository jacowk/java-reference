package za.co.reference.designpatterns.creationalpatterns.multiton;

import java.util.HashMap;
import java.util.Map;

public class FooMultiton 
{
    private static final Map<Object, FooMultiton> instances = new HashMap<Object, FooMultiton>();

    private FooMultiton() // also acceptable: protected, {default}
    {
        /* no explicit implementation */
    }

    public static FooMultiton getInstance(Object key)
    {
        synchronized (instances) {

            // Our "per key" singleton
            FooMultiton instance = instances.get(key);

            if (instance == null) {

                // Lazily create instance
                instance = new FooMultiton();

                // Add it to map   
                instances.put(key, instance);
            }

            return instance;
        }
    }

    public Foo getFoo()
    {
    	return foo;
           /* implementation not pertinent to pattern */
    }

    public void setFoo(Foo foo)
    {
           /* implementation not pertinent to pattern */
    }
    
    private Foo foo;
}
