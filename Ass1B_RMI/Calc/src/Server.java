import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) {
        try {
//            Instantiating implementation class
            CalcClass obj = new CalcClass();

//            Exporting object of implementation class to stub
            CalcInterface stub = (CalcInterface) UnicastRemoteObject.exportObject(obj,5000);

//            Binding stub to registry
            Registry registry = LocateRegistry.getRegistry();

            registry.bind("Calculator", stub);
            System.out.println("Server Ready");
        }
        catch (Exception e){
            System.err.println("Server Exception:" + e.toString());
            e.printStackTrace();
        }
    }
}
