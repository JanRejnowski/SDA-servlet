package sockets;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by RENT on 2017-06-20.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.100.178", 1234);
        boolean flag = true;
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner scanner = new Scanner(socket.getInputStream());
        Scanner scannerToUser = new Scanner(System.in);
        while (flag) {
            writer.write(scannerToUser.nextLine() + "\n");
            writer.flush();
            System.out.println("Guest: " + scanner.nextLine());
        }
        socket.close();
    }
}
