package za.co.reference.java8durgasoft.lambda.example3;

import za.co.reference.java8durgasoft.functionalinterfaces.example3.Interf;

public class Test
{

  public static void main(String[] args)
  {
    Interf i = x -> x*x;
    System.out.println("The square of 5 is " + i.square(5));
  }
  
}
