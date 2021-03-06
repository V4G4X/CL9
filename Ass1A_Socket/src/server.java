import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ServerSocket ss = new ServerSocket(5000);
        Socket s = ss.accept();
        System.out.println("Server Socket opened");
        System.out.println("Socket now accepting");
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        String input, output;
        try {
            while (true) {
                System.out.println("Awaiting Messages from Client");
                input = dis.readUTF();
                System.out.println("Message Received: " + input);
                System.out.print("Write Return Message to Client: ");
                output = sc.nextLine();
                if (output.equals("exit"))
                    break;
                else {
                    dos.writeUTF(output);
                    dos.flush();
                }
            }
        }
        catch (EOFException e){
            System.out.println("Client has disconnected");
        }
        dis.close();
        dos.close();
        ss.close();
    }
}
