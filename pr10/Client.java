import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) {
        try {
            // Lookup for the remote object
            RemoteInterface service = (RemoteInterface) Naming.lookup("rmi://localhost:5000/verify");

            // Strings to compare
            String str1 = "Hello";
            String str2 = "Hello, World!";

            // Call the remote method
            int result = service.verify(str1, str2);

            // Check the result and display the appropriate message
            if (result == 0) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
