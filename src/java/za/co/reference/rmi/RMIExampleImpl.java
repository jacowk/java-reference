package za.co.reference.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIExampleImpl extends UnicastRemoteObject implements RMIExample{

	protected RMIExampleImpl() throws RemoteException{
		super();
	}

	@Override
	public void passByReferenceARgument(ArgumentObject argumentObject) throws RemoteException{
		System.out.println("passByReferenceARgument called");
	}

	@Override
	public void passByValueArgument(Integer num) throws RemoteException{
		System.out.println("passByValueArgument called");
	}

	@Override
	public void passPrimitiveArgument(int num) throws RemoteException{
		System.out.println("passPrimitiveArgument called");
	}

	@Override
	public ArgumentObject returnByReferenceARgument() throws RemoteException{
		System.out.println("returnByReferenceARgument called");
		return new ArgumentObjectImpl();
	}

	@Override
	public Integer returnByValueArgument() throws RemoteException{
		System.out.println("returnByValueArgument called");
		return new Integer(1000);
	}

	@Override
	public int returnPrimitiveArgument() throws RemoteException{
		System.out.println("returnPrimitiveArgument called");
		return 500;
	}

	@Override
	public void throwException() throws RemoteException{
		System.out.println("throwException called");
		throw new RemoteException("Some error message");
	}

}
