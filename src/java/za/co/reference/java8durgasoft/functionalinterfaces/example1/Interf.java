package za.co.reference.java8durgasoft.functionalinterfaces.example1;

@FunctionalInterface
public interface Interf
{

  public abstract void methodOne();
  
  default void methodTwo()
  {
    System.out.println("MethodTwo Execution");
  }
  
}
