package za.co.reference.rmi.example4;

import java.rmi.Naming;

public class HelloClient 
{
    public static void main (String[] argv) {
    try {
      HelloInterface hello =(HelloInterface) Naming.lookup ("//192.168.10.201/Hello");
      System.out.println (hello.say());
    } 
	catch (Exception e){
		System.out.println ("HelloClient exception: " + e);}
  }
}
