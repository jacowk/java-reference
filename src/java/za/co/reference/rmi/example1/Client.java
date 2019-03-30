package za.co.reference.rmi.example1;

import java.rmi.Naming;

public class Client
{
  public static void main(String args[])
  {
    try
    {
      String ip="rmi://192.168.1.97/RMIAPPLICATION";
      RemoteInterface s=(RemoteInterface)Naming.lookup(ip);
      System.out.println("sum: "+ s.add(1,3));
    }
    catch(Exception e)
    {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }
} 