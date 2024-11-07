import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote {

    double solve(int a , int b) throws RemoteException;
}
