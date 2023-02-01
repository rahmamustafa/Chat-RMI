package gov.iti.io.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInt extends Remote {

    public void tellOthers(String messageFrom ,String imageUrl, String message) throws RemoteException;
    public void register(ClientServerInt name) throws RemoteException;
    public void unRegister(ClientServerInt name) throws RemoteException;

}
