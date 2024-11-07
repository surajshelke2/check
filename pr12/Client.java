import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {

        RemoteInterface remoteInterface = (RemoteInterface) Naming.lookup("rmi://localhost:5000/server");

        boolean ans = remoteInterface.solve(10);

        if(ans){

            System.out.println("The number is Prime");
        }else{

            System.out.println("The number is Not Prime");
        }
    }
}
