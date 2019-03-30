package za.co.reference.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIExample extends Remote{
	
	//This parameter is primitive
	public void passPrimitiveArgument(int num) throws RemoteException;
	
	//This parameter implements Serializable
	public void passByValueArgument(Integer num) throws RemoteException;
	
	//This parameter implements Remote
	public void passByReferenceARgument(ArgumentObject argumentObject) throws RemoteException;
	
	
	//This return value is primitive
	public int returnPrimitiveArgument() throws RemoteException;
	
	//This return value implements Serializable
	public Integer returnByValueArgument() throws RemoteException;
	
	//This return value implements Remote
	public ArgumentObject returnByReferenceARgument() throws RemoteException;
	
	
	//This method throws an exception
	public void throwException() throws RemoteException;

}
