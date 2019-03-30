package za.co.reference.practice.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIExampleImpl extends UnicastRemoteObject implements RMIExample{
	
	public RMIExampleImpl() throws RemoteException{
		super();
	}

	@Override
	public void test() throws RemoteException{
		System.out.println("Hello RMI world");
	}

}
