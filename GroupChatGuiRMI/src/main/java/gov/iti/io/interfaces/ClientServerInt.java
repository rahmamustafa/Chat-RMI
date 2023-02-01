package gov.iti.io.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientServerInt extends Remote {
    public void recieve(String name,String imageUrl ,String message) throws RemoteException;
    public String getName() throws RemoteException;
}
