package gov.iti.io.Client;

import gov.iti.io.interfaces.ServerInt;
import gov.iti.io.interfaces.ClientServerInt;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class RMIClient {


    public RMIClient() {
        try {
            Registry reg = LocateRegistry.getRegistry(3100);

            ClientServerInt clientServerInt = new ClientServerImpl("Rahmaaa","");
            ServerInt group = (ServerInt) reg.lookup("ChatApp");

            group.register(clientServerInt);

            group.tellOthers(clientServerInt.getName(), clientServerInt.getImage(), "Hello");
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

    public static void main(String args[]) {
        new RMIClient();

    }

}
