package gov.iti.io.Client;

import gov.iti.io.interfaces.ClientServerInt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientServerImpl  extends UnicastRemoteObject implements ClientServerInt {
    String name;
    String image;


 public ClientServerImpl(String name , String image) throws RemoteException {
        this.name = name;
        this.image=image;

    }

    @Override
    public void recieve(String name ,String image,String message) {
        //gui.recieve(message);
        if(!this.name.equals(name))
            System.out.println(message);
    }

    @Override
    public String getName() throws RemoteException {
        return name;
    }

    @Override
    public String getImage() throws RemoteException {
        return image;
    }



}
