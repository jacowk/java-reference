package za.co.reference.rmi.myexample;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TestImpl extends UnicastRemoteObject implements TestRemoteInterface{

	protected TestImpl() throws RemoteException{
		super();
	}

	@Override
	public void message(String message){
		System.out.println("Message received: " + message);
	}

}
