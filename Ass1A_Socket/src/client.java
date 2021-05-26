import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Socket s = new Socket("localhost", 5000);
        System.out.println("Socket opened");
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        String input, output;
        try {
            while (true) {
                System.out.print("Send message to Server: ");
                output = sc.nextLine();
                if (output.equals("exit"))
                    break;
                else {
                    dos.writeUTF(output);
                    dos.flush();
                }
                input = dis.readUTF();
                System.out.println("Message Received: " + input);

            }
        } catch (EOFException e) {
            System.out.println("Server has shutdown");
        }
        dis.close();
        dos.close();
        s.close();
    }
}
