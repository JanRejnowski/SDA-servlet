package warmup.moreless;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by RENT on 2017-06-22.
 */
public class GameClient {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 1234);
        Scanner socketIn = new Scanner(socket.getInputStream());
        BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        int result = 0;
        Scanner scannerFromUser = new Scanner(System.in);
        do {
            System.out.println("Insert number");
            int number = scannerFromUser.nextInt();

            socketOut.write(number + "\n");
            socketOut.flush();

            String serverResponse = socketIn.nextLine();
            result = Integer.valueOf(serverResponse);
            String message;
            if (1 == result) {
                System.out.println("Value too high");
            } else if (-1 == result) {
                System.out.println("Value too low");
            }
        } while(result != 0);
        System.out.println("Correct value!");
        socket.close();
    }
}
