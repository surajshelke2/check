import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject  implements RemoteInterface {


    protected Server() throws RemoteException {
        super();
    }

    @Override
    public double solve(int a, int b) throws RemoteException {
       double ans =Math.pow(a,b);
       return ans;


    }


    public static void main(String[] args) throws RemoteException, MalformedURLException {

        Server server = new Server();
        Naming.rebind("rmi://localhost:5000/solve",server);
        System.out.println("Server is Running...");

    }
}
