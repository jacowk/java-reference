package za.co.reference.java8durgasoft.lambda.example1;

import za.co.reference.java8durgasoft.functionalinterfaces.example1.Interf;

public class Demo
{

  public static void main(String[] args)
  {
    Interf i = () -> System.out.println("MethodOne Execution");
    i.methodOne();
    i.methodTwo();
  }
  
}
