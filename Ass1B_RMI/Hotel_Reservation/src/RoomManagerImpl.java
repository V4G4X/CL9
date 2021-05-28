import java.rmi.RemoteException;
import java.util.Set;

public class RoomManagerImpl implements RoomManager {

    @Override
    public String book(int roomType, String guestName) throws RemoteException {
        try {
            if (vacancy[roomType] > 0) {
                // If the desired type of Room is available
                vacancy[roomType]--;
                guests.add(guestName);
                return String.format("Room of type %d is booked, please pay %d₹ at the bill desk.", roomType, costs[roomType]);
            } else {
                // If the desired type of Room is available
                return "The desired suite of Rooms are all booked.\nPlease Book another.";
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //If User Enters a room type that is outside our list.
            return "Enter Proper Room Type";
        }
    }

    // Returns the amount of vacant rooms for each room type
    @Override
    public int[] list() throws RemoteException {
        return vacancy;
    }

    //Returns Set of names of Guests
    @Override
    public Set<String> getGuests() throws RemoteException {
        return guests;
    }

    //Returns the standard Help Message
    @Override
    public String help() throws RemoteException {
        // Help String which will be printed at User's terminal
        return "java HotelClient list <server address>: list the available number of rooms in each price range.\n" +
                "java HotelClient book <server address> <room type> <guest name>: books a room of the specified type (if available), and registers the name of the guest.\n" +
                "java HotelClient guests <server address>: list the names of all the registered guests.";
    }
}
