package homework;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by RENT on 2017-06-21.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        boolean flag = true;
        while (flag) {


            Socket socket = serverSocket.accept();

            Scanner scanner = new Scanner(socket.getInputStream());
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            int sum = 0;
            for (int i = 0; i < 5; i++) {
                String input = scanner.nextLine();
                Integer integer = Integer.valueOf(input);
                System.out.println("Received number: " + input);
                sum += integer;
            }

            writer.write(sum + "\n");
            writer.flush();

            socket.close();
        }
        serverSocket.close();
    }
}
