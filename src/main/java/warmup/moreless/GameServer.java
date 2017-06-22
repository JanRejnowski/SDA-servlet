package warmup.moreless;

import homework.Server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;


/**
 * Created by RENT on 2017-06-22.
 */
public class GameServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        boolean flag = true;

        while (flag) {
            Socket socket = serverSocket.accept();

            Scanner socketIn = new Scanner(socket.getInputStream());
            BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Random random = new Random();
            int number = random.nextInt(100);
            System.out.println("Generated number: " + number);
            int compareResult;
            do {
                String value = socketIn.nextLine();
                Integer incomeValue = Integer.valueOf(value);
                compareResult = Integer.compare(incomeValue, number);
                compareResult = Integer.signum(compareResult);
                socketOut.write(compareResult + "\n");
                socketOut.flush();
            } while (compareResult != 0);
            socket.close();
        }
        serverSocket.close();
    }
}
