package za.co.reference.rmi.example3;

import java.rmi.Remote;

public interface RemoteInterface2 extends Remote{
	
	public int sub(int x,int y) throws Exception;
	
} 