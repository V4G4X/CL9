import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UploadResultImpl extends Remote {
    void storeString(String input) throws RemoteException, IOException;
}
