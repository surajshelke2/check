import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements RemoteInterface {


    protected Server() throws RemoteException {
        super();
    }

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {

        Server server = new Server();
        Naming.rebind("rmi://localhost:5000/server",server);
        System.out.println("Server is Running...");


    }

    @Override
    public boolean solve(int a) throws RemoteException {

        for(int i=1;i<a;i++){

            if(a%i == 0) return false;
        }
        return true;
    }
}
