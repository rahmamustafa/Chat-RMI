package gov.iti.io.interfaces;

import gov.iti.io.interfaces.ClientServerInt;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInt extends Remote {

    public void tellOthers(String messageFrom ,String imageUrl, String message) throws RemoteException;
    public void register(ClientServerInt name) throws RemoteException;
    public void unRegister(ClientServerInt name) throws RemoteException;

}
