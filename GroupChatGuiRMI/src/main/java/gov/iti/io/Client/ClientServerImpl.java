package gov.iti.io.Client;

import gov.iti.gui.controllers.chatController;
import gov.iti.io.interfaces.ClientServerInt;
import javafx.application.Platform;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientServerImpl  extends UnicastRemoteObject implements ClientServerInt {
    String name;
    String image;
    chatController gui;


 public ClientServerImpl(chatController gui,String name,String image) throws RemoteException {
        this.name = name;
        this.gui=gui;
        this.image=image;
    }

    @Override
    public void recieve(String name ,String image,String message) {

        if(!this.name.equals(name)&&!message.startsWith("server"))
            Platform.runLater(()->gui.acceptGroupMessage(name,image ,message));
        else if(message.startsWith("server"))
            Platform.runLater(()->gui.welcomeMessage(message.substring(7)));

    }

    @Override
    public String getName() throws RemoteException {
        return name;
    }


}
