package za.co.reference.java8durgasoft.lambda.example2;

import za.co.reference.java8durgasoft.functionalinterfaces.example2.Interf;

public class Test
{

  public static void main(String[] args)
  {
    Interf i = (a,b) -> System.out.println("The Sum: " + (a + b));
    i.sum(5, 10);
  }
  
}
