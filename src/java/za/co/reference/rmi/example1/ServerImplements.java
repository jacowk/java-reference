package za.co.reference.rmi.example1;

import java.rmi.server.UnicastRemoteObject;

public class ServerImplements extends UnicastRemoteObject implements RemoteInterface{

	public ServerImplements() throws Exception{
		super();
	}
	
	public int add(int x,int y){
		return (x+y);
	}

} 