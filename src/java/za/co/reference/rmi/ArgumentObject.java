package za.co.reference.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ArgumentObject extends Remote{
	
	public int argumentObjectReference() throws RemoteException;

}
