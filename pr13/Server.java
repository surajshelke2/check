import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements RemoteInterface {

    protected Server() throws RemoteException {
        super();
    }

    @Override
    public double solve(int feet) throws RemoteException {
        return feet*0.304;
    }

    public static void main(String[] args) throws MalformedURLException, RemoteException {

        Server server = new Server();
        Naming.rebind("rmi://localhost:5000/solve",server);
        System.out.println("Server is Login");
    }
}
