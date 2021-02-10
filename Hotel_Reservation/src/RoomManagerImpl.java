import java.rmi.RemoteException;
import java.util.Set;

public class RoomManagerImpl implements RoomManager{

    @Override
    public String book(int roomType, String guestName) throws RemoteException {
        if (vacancy[roomType] > 0) {
            // If the desired type of Room is available
            vacancy[roomType]--;
            guests.add(guestName);
            return String.format("Room of type %d is booked, please pay %d$ at the billdesk.", roomType, costs[roomType]);
        } else {
            // If the desired type of Room is available
            return "The desired suite of Rooms are all booked.\nPlease Book another.";
        }
    }

    @Override
    public int[] list() throws RemoteException {
        return vacancy;
    }

    @Override
    public Set<String> getGuests() throws RemoteException {
        return guests;
    }

    @Override
    public  String help() throws RemoteException {
        // Help String which will be printed at User's terminal
        return "java HotelClient list <server address>: list the available number of rooms in each price range.\n" +
                "java HotelClient book <server address> <room type> <guest name>: books a room of the specified type (if available), and registers the name of the guest.\n" +
                "java HotelClient guests <server address>: list the names of all the registered guests.";
    }
}
