import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

    public static void main(String[] args) {
        try {
            // Look up the remote service by its name in the RMI registry
            RemoteInterface service = (RemoteInterface) Naming.lookup("rmi://localhost:5000/SubstringVerificationService");

            // Strings to be verified
            String str1 = "Hello, World!";
            String str2 = "World";

            // Call the remote method and print the result
            String result = service.verifyString(str1, str2);
            System.out.println("Result: " + result);
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
