package za.co.reference.rmi.example4;

import java.rmi.*;

public interface HelloInterface extends Remote {
    public String say() throws RemoteException;
}
