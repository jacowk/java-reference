package za.co.reference.rmi.example3;

import java.rmi.Naming;

public class Server2{
	
	public static void main(String args[]){
		try{
			ServerImplements s = new ServerImplements();
			Naming.rebind("RMIAPPLICATION", s);
			System.out.println("Server Started 2");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

}