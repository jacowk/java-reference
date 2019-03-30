package za.co.reference.java8durgasoft.functionalinterfaces.consumer.chaining;

import java.util.function.Consumer;

public class Test
{

  public static void main(String[] args)
  {
    Consumer<Movie> c1 = m -> System.out.println("Movie:" + m.name + " is ready to release");
    Consumer<Movie> c2 = m -> System.out.println("Movie:" + m.name + " is just released and it is a " + m.result);
    Consumer<Movie> c3 = m -> System.out.println("Movie:" + m.name + " information stored");

    Consumer<Movie> chainedC = c1.andThen(c2).andThen(c3); /* Chained consumer */
    
    Movie m1 = new Movie("Bahubali", "Hit");
    chainedC.accept(m1);
    
    Movie m2 = new Movie("Spider", "Flop");
    chainedC.accept(m2);
  }
  
}
