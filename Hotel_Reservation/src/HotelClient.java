import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HotelClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(null);

//            Look Up Registry for "HotelBookng" stub
            RoomManager stub = (RoomManager) registry.lookup("HotelBooking");

            System.out.println(String.format("args[1]: %s", args[1]));
            if (args[1].isEmpty()) {
                System.out.println(stub.help());
            }

        } catch (Exception e) {
//            System.err.println(String.format("Client Exception: %s",e.toString()));
            e.printStackTrace();
        }
    }
}
