import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ResultServer {
    public static void main(String[] args) {
        try {
            //Remote Object that will be binded to the Registry after casted as UnicastRemoteObject stub
            UploadResultImpl obj = new UploadResult();
            //Cast it through UnicastRemoteObject to export it as a stub
            UploadResultImpl stub = (UploadResultImpl) UnicastRemoteObject.exportObject(obj, 5000);

            //Locate the registry reference
            Registry registry = LocateRegistry.getRegistry();
            //Bind the stub to registry
            registry.bind("UploadString", stub);
            System.out.println("Server Writer Ready");
        } catch (Exception e) {
            System.err.println("Server Exception Occurred: " + e.toString());
            e.printStackTrace();
        }

    }
}
