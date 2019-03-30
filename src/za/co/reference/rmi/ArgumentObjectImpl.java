package za.co.reference.rmi;

import java.rmi.RemoteException;

public class ArgumentObjectImpl implements ArgumentObject{

	@Override
	public int argumentObjectReference() throws RemoteException{
		return 30;
	}

}
