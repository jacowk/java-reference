package za.co.reference.practice.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIExample extends Remote{
	
	public void test() throws RemoteException;

}
