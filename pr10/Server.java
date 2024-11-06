import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements RemoteInterface {

    protected Server() throws RemoteException {
        super();
    }

    @Override
    public int verify(String str1, String str2) throws RemoteException {
        int counter1 = 0;
        int counter2 = 0;

        // Count vowels in str1
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (isVowel(ch)) {
                counter1++;
            }
        }

        // Count vowels in str2
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            if (isVowel(ch)) {
                counter2++;
            }
        }

        // If both have the same vowel count, return 1; otherwise, return 0
        return (counter1 == counter2) ? 1 : 0;
    }

    // Helper method to check if a character is a vowel
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        try {
            // Create server instance and bind it to RMI registry
            Server server = new Server();
            Naming.rebind("rmi://localhost:5000/verify", server);
            System.out.println("Server is Running ....");
        } catch (RemoteException | MalformedURLException e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
