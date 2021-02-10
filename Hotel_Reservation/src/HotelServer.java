import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HotelServer extends RoomManagerImpl {
    public static void main(String[] args) {
        try {
//            Instantiating the implementation class/interface
            RoomManagerImpl obj = new RoomManagerImpl();
//            Exporting the object to stub
            RoomManager stub = (RoomManager) UnicastRemoteObject.exportObject(obj, 5000);

//            Binding the stub to the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("HotelBooking", stub);

            System.out.println("Hotel Server Ready");
        } catch (Exception e) {
            System.err.println(String.format("Server Exception: %s", e.toString()));
            e.printStackTrace();
        }
    }
}
