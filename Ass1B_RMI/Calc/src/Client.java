import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
//        Getting the registry
            Registry registry = LocateRegistry.getRegistry();
//        Looking up registry for Remote Object
            CalcInterface stub = (CalcInterface)registry.lookup("Calculator");

            Scanner sc = new Scanner(System.in);
            int ch;
            do{
                System.out.println("Enter Operation for Calculator");
                System.out.println("1 for Addition");
                System.out.println("2 for Subtraction");
                System.out.println("3 for Multiplication");
                System.out.println("4 for Division");
                System.out.println("5 to Exit");
                ch = sc.nextInt();
                if(ch==5)
                break;
                System.out.print("Enter first number: ");
                int a = sc.nextInt();
                System.out.print("Enter second number: ");
                int b = sc.nextInt();
                switch (ch){
                    case 1:{
                        System.out.println("Addition: " + stub.add(a,b));
                        break;
                    }
                    case 2:{
                        System.out.println("Subtraction: " + stub.subtract(a,b));
                        break;
                    }
                    case 3:{
                        System.out.println("Multiplication: " + stub.multiply(a,b));
                        break;
                    }
                    case 4:{
                        try {
                            System.out.println("Division: " + stub.divide(a,b));
                        }catch (ArithmeticException e){
                            System.err.println("Divide by 0 Exception");
                        }
                        break;
                    }
                    default:
                        System.err.println("Enter proper choice of operation!");
                }
            }while(true);
        }catch (Exception e){
            System.err.println("Server Exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
