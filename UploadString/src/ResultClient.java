import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ResultClient {
    public static void main(String[] args) {
        try {
            String input = String.join(" ", args);
            if (input.equals(""))
                System.out.println("Enter some input!");
            else {
                //Locate the Registry reference
                Registry registry = LocateRegistry.getRegistry();

                //Look up registry for stub
                UploadResultImpl stub = (UploadResultImpl) registry.lookup("UploadString");

                stub.storeString(input);
                System.out.println("Input String sent to Server.");
            }
        } catch (Exception e) {
            System.err.println("Client Exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
