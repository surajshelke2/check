import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote {

    int verifyString(String str1 , String str2) throws RemoteException;


}
