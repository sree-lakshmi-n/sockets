package twoWayCommn.client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8000);

            Scanner sc = new Scanner(socket.getInputStream());  // read data from server
            PrintStream ps = new PrintStream(socket.getOutputStream()); // for sending data to server

            Scanner scInput = new Scanner(System.in);
            System.out.println("Enter a number: ");
            String str = scInput.nextLine();
            ps.println(str);

            String msg = sc.nextLine();
            System.out.println(msg);

            sc.close();
            scInput.close();
            ps.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
