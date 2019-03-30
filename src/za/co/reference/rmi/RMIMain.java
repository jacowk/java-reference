package za.co.reference.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIMain{
	
	public static void main(String[] args){
		try{
			RMIExample rmiExampleBind = new RMIExampleImpl();
			Naming.rebind("RMIExample", rmiExampleBind);
			
			RMIExample rmiExampleLookup = (RMIExample)Naming.lookup("rmi://localhost/RMIExample");
			rmiExampleLookup.passByReferenceARgument(new ArgumentObjectImpl());
			rmiExampleLookup.passByValueArgument(new Integer(100));
			rmiExampleLookup.passPrimitiveArgument(400);
			rmiExampleLookup.returnByReferenceARgument();
			rmiExampleLookup.returnByValueArgument();
			rmiExampleLookup.returnPrimitiveArgument();
			rmiExampleLookup.throwException();
		}
		catch (RemoteException re){
			re.printStackTrace();
		}
		catch (MalformedURLException mu){
			mu.printStackTrace();
		}
		catch (NotBoundException nbe){
			nbe.printStackTrace();
		}
	}

}
