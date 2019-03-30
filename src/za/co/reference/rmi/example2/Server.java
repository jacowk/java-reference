package za.co.reference.rmi.example2;

import java.rmi.Naming;

public class Server{
	
	public static void main(String args[]){
		try{
			ServerImplements s = new ServerImplements();
			Naming.rebind("RMIAPPLICATION", s);
			System.out.println("Server has been started");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

}