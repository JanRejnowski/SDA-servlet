package sockets;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by RENT on 2017-06-20.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        boolean flag = true;
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Waiting for connection");
        Socket socket = serverSocket.accept();
        System.out.println("Connection established");

        Scanner scanner = new Scanner(socket.getInputStream());
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner scannerToUser = new Scanner(System.in);
         while (flag) {
            String input = scanner.nextLine();
            System.out.println("Guest: " + input);
            writer.write(scannerToUser.nextLine() + "\n");
            writer.flush();
        }

        socket.close();
        serverSocket.close();
    }
}
