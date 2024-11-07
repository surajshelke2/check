import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {

        RemoteInterface remoteInterface = (RemoteInterface) Naming.lookup("rmi://localhost:5000/solve");

        double ans = remoteInterface.solve(5);

        System.out.println("Result :"+ans);

    }
}
