package gov.iti.io.Client;

import gov.iti.gui.controllers.chatController;
import gov.iti.io.interfaces.ClientServerInt;
import gov.iti.io.interfaces.ServerInt;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class RMIClient {

    ServerInt group;
    ClientServerInt clientServerInt;
    String id;
    String imageUrl;

    public RMIClient(chatController chatController ,String id,String imageUrl) {
        try {
            Registry reg = LocateRegistry.getRegistry(3100);
            this.id=id;
            this.imageUrl=imageUrl;
            clientServerInt = new ClientServerImpl(chatController,id,imageUrl);
            group = (ServerInt) reg.lookup("ChatApp");
            group.register(clientServerInt);
            group.tellOthers(id,imageUrl, "server," +id+" joined the chat");
            Runtime.getRuntime().addShutdownHook(new Thread(() ->
            {
                try {
                    group.unRegister(clientServerInt);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }
            ));


            //System.out.println(str);
        } catch (AccessException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }


    public void tell(String message){
        try {
            group.tellOthers(id,imageUrl,message);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }


    public void unRegister() {
        try {
            group.unRegister(clientServerInt);
            group.tellOthers(id, imageUrl,"server," +id+" left");
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
