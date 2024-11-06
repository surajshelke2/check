import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements RemoteInterface {

    protected Server() throws RemoteException {
        super();
    }

    public static void main(String[] args) {
        try {
            System.out.println("Server is running...");

            // Create a new instance of Server
            Server server = new Server();

            // Bind the server instance to the RMI registry with a unique name
            Naming.rebind("rmi://localhost:5000/SubstringVerificationService", server);

            System.out.println("Service bound to RMI registry as 'SubstringVerificationService'");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String verifyString(String str1, String str2) throws RemoteException {
        if (str1.contains(str2)) {
            return "Yes, '" + str2 + "' is a substring of '" + str1 + "'.";
        } else {
            return "No, '" + str2 + "' is not a substring of '" + str1 + "'.";
        }
    }
}
