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
            int result = service.verifyString(str1, str2);

            // Display appropriate message based on result
            if (result == 0) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }

        } catch (MalformedURLException e) {
            System.err.println("URL is malformed: " + e.getMessage());
        } catch (NotBoundException e) {
            System.err.println("Service not bound: " + e.getMessage());
        } catch (RemoteException e) {
            System.err.println("Remote exception occurred: " + e.getMessage());
        }
    }
}
