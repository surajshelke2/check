import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements ServerInterface {

    protected Server() throws RemoteException {
        super();
    }

    @Override
    public String concatenate(String str1, String str2) throws RemoteException {
        return str1 + str2;
    }

    public static void main(String[] args) {
        try {
            // Create and export the remote object
            Server server = new Server();
            // Bind the remote object in the RMI registry with the name "ConcatenationService"
            Naming.rebind("rmi://localhost:5000/ConcatenationService", server);
            System.out.println("Server is running...");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
