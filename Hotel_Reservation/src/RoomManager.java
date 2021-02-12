import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Set;

//Remote Object Interface Declarations
public interface RoomManager extends Remote {
    int[] vacancy = {10, 20, 5, 3, 2};
    int[] costs = {550, 750, 800, 1500, 2300};
    Set<String> guests = new HashSet<>();

    String book(int roomType, String guestName) throws RemoteException;
    int[] list() throws RemoteException;
    Set<String> getGuests() throws RemoteException;
    String help() throws RemoteException;
}
