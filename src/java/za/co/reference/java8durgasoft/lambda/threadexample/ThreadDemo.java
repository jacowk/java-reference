package za.co.reference.java8durgasoft.lambda.threadexample;

public class ThreadDemo
{

  //TODO: Continue with anonymous inner classes vs Lambda p 9
  public static void main(String[] args)
  {
    Runnable r = () -> {
      for (int i = 0; i < 10; i++)
      {
        System.out.println("Child Thread");
      }
    };
    
    Thread t = new Thread(r);
    t.start();
    for (int i = 0; i < 10; i++)
    {
      System.out.println("Main thread");
    }
  }
  
}
