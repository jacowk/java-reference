package za.co.reference.rmi.myexample;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TestRemoteInterface extends Remote{
	
	public void message(String message) throws RemoteException;

}
