package twoWayCommn.server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Server started...");

                Scanner sc = new Scanner(socket.getInputStream());  // read data from client
                PrintStream ps = new PrintStream(socket.getOutputStream()); // for sending data to client
                String msg = sc.nextLine();
                int num = Integer.parseInt(msg);
                if (num > 0)
                    ps.print(msg + " is positive");
                else if (num < 0)
                    ps.print(msg + " is negative");
                else
                    ps.print(msg + " is zero");

                sc.close();
                ps.flush();
                socket.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
