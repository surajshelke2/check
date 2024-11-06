import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements RemoteInterface {

    protected  Server() throws RemoteException{

            super();
    }
    public static void main(String[] args) throws MalformedURLException, RemoteException {

        Server server = new Server();
        System.out.println("Server is Running...");
        Naming.rebind("rmi://localhost:5000/verify",server);

        System.out.println("RMI Running faster");


    }

    @Override
    public int verifyString(String str1, String str2) throws RemoteException {

        String string = "";
        char ch;

        if(str1.length() != str2.length()) return 0;

        for (int i = 0; i < str1.length(); i++) {

            ch = str1.charAt(i);
            string = ch + string;

        }

        return string.compareTo(str2);

    }
}
