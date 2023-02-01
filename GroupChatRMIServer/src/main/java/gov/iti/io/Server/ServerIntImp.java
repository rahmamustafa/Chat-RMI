package gov.iti.io.Server;

import gov.iti.io.interfaces.ClientServerInt;
import gov.iti.io.interfaces.ServerInt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

public class ServerIntImp extends UnicastRemoteObject implements ServerInt {

   Vector<ClientServerInt> allClients = new Vector<>();

    public ServerIntImp() throws RemoteException {
        super();
        //TODO Auto-generated constructor stub
    }


    @Override
    public void tellOthers(String messageFrom,String imageUrl , String message) throws RemoteException {
        System.out.println("Messge received: "+message + "From" + messageFrom);
        for (ClientServerInt client : allClients){
            try {
                client.recieve(messageFrom,imageUrl,message);
            }catch (RuntimeException e){
                System.out.println("error");
            }

        }
    }

    @Override
    public void register(ClientServerInt name) throws RemoteException {
        System.out.println("Client added: "+name.getName());
        allClients.add(name);
    }

    @Override
    public void unRegister(ClientServerInt name) throws RemoteException {
        System.out.println("Client removed: "+name.getName());
        allClients.remove(name);
    }
}
