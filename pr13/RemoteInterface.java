import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote {

    double solve(int feet) throws RemoteException;
}
