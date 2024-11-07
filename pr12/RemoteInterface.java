import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote  {

    boolean solve(int a) throws RemoteException;
}
