package gov.iti.io.Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public RMIServer() {
        try {
            ServerIntImp obj = new ServerIntImp();
            Registry reg = LocateRegistry.createRegistry(3100);

            reg.rebind("ChatApp", obj);
            System.out.println("Server is waiting ... ");

        } catch (RemoteException ex) {

        }
    }

    public static void main(String args[]) {
        new RMIServer();
    }

}
