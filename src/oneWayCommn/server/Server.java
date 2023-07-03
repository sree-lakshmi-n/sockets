package oneWayCommn.server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4567);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Connection Established");

            // Write or send OutputStream
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.print("Greetings!");

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter message to be sent");
            String str = sc.nextLine();
            ps.print(str);

            ps.flush();
            socket.close();
        }
    }
}
