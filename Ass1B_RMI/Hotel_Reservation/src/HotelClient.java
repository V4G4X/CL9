import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Set;

public class HotelClient {
    public static void main(String[] args) {
        try {
//                Get the Registry reference
            Registry registry = LocateRegistry.getRegistry(null);

//            Look Up Registry for "HotelBooking" stub
            RoomManager stub = (RoomManager) registry.lookup("HotelBooking");

//            If user doesn't give any arguments or asks for help, then provide
            if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
                System.err.println("Help below: ");
                System.err.println(stub.help());
            } else {
                //When User provides at least one argument
                String option = args[0];
                switch (option.toLowerCase()) {
                    //When first argument is "list"
                    case "list": {
//                        Print the Vacancies for each room type with their associated costs
                        printVacancies(stub.list(), RoomManager.costs);
                        break;
                    }
                    //When first argument is "book"
                    case "book": {
                        try {
//                            User provides room type as argument 2
                            int room = Integer.parseInt(args[1]);
//                            User provides Guest name as argument 3
                            String name = args[2];
//                            Attempt to Book that room type for that guest and print the output
                            System.out.println(stub.book(room, name));
                        } catch (ArrayIndexOutOfBoundsException e) {
                            //If User provides lesser arguments than required
                            System.err.println("Enter proper arguments!\nSee 'java HotelClient help' for detailed help.");
                        } catch (NumberFormatException e) {
                            //If User provides a non-number as room type( which goes from 0 to 4 only)
                            System.err.println("Room Type is a number!");
                        }
                        break;
                    }
                    case "guests": {
                        //When first argument is "guests"
                        printGuests(stub.getGuests());
                        break;
                    }
                    default:
                        //When the first argument is unrecognised.
                        System.err.println("Enter Proper Option");
                        System.err.println(stub.help());
                }
            }

        } catch (Exception e) {
            //When Un-identified Error Occurs
            System.err.printf("Client Exception: %s%n",e.toString());
            e.printStackTrace();
        }
    }

//    Prints formatted vacancies and costs for each room type on StdOut
    public static void printVacancies(int[] vacancy, int[] cost)
    {
        for (int i = 0; i < vacancy.length; ++i)
            System.out.printf("%2d rooms of type %d are available for %4d₹ per night%n", vacancy[i], i, cost[i]);
    }

//    Prints the name of each current Guest on StdOut
    public static void printGuests(Set<String> guests) {
        if (guests.isEmpty()) {
            System.out.println("No current guests, All rooms are available!!!");
        } else {
            System.out.println("The Following guests are currently accommodated for: ");
            for (String guest : guests)
                System.out.println(guest);
        }
    }
}
