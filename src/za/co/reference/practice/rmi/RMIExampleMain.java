package za.co.reference.practice.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIExampleMain{
	
	public static void main(String[] args){
		try{
			RMIExample rmiExampleBind = new RMIExampleImpl();
			Naming.rebind("rmiExampleBind", rmiExampleBind);
			
			RMIExample rmiExampleLookup = (RMIExample)Naming.lookup("//localhost/rmiExampleBind");
			rmiExampleLookup.test();
		}
		catch (RemoteException re){
			re.printStackTrace();
		}
		catch (MalformedURLException mue){
			mue.printStackTrace();
		}
		catch (NotBoundException nbe){
			nbe.printStackTrace();
		}
	}

}
