package za.co.reference.rmi.example3;

import java.rmi.server.UnicastRemoteObject;

public class ServerImplements2 extends UnicastRemoteObject implements RemoteInterface2{
	
	public ServerImplements2() throws Exception{
		super();
	}
	
	public int sub(int x, int y){
		return (x - y);
	}

} 