package za.co.reference.rmi.example1;

import java.rmi.Naming;

public class  Server
{
  public static void main(String args[])
  {
    try
    {
      ServerImplements s=new ServerImplements();
      Naming.rebind("SERVICE",s);
      System.out.println("Server Started ");
    }
    catch(Exception e)
    {
      System.out.println(e.getMessage());
    }
  }

} 