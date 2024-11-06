import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

    public static void main(String[] args) {
        try {
            // Look up the remote object from the RMI registry
            ServerInterface service = (ServerInterface) Naming.lookup("rmi://localhost:5000/ConcatenationService");

            // Strings to be concatenated
            String str1 = "Hello";
            String str2 = "Suraj";

            // Call the remote method
            String result = service.concatenate(str1, str2);

            // Print the result
            System.out.println("Concatenated Result: " + result);
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
