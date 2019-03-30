package za.co.reference.rmi.example3;

import java.rmi.Naming;

public class Client {
	  public static void main(String args[]) {
	    try {
	      String ip = "rmi://192.168.10.97/SERVICE";
	      String ip2 = "rmi://192.168.10.113/SERVICE2";

	      RemoteInterface s = (RemoteInterface) Naming.lookup(ip);
	      RemoteInterface2 s2 = (RemoteInterface2) Naming.lookup(ip2);

	      System.out.println("Add:" + s.add(1, 4));
	      System.out.println("sub:" + s2.sub(3, 1));
	    } catch (Exception e) {
	      System.out.println(e.getMessage());
	      e.printStackTrace();
	    }
	  }
	} 