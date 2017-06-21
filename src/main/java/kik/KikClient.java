package kik;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by RENT on 2017-06-21.
 */
public class KikClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.100.178", 1234);

        Scanner scanner = new Scanner(System.in);

        BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner socketIn = new Scanner(socket.getInputStream());

        Board board = new Board();
        boolean flag = true;

        System.out.println("Waiting for first move");
        while (flag) {
            String opponentPosition = socketIn.nextLine();
            Integer position = Integer.valueOf(opponentPosition);
            board.addMove(position, "X");

            System.out.println(board);
            boolean status;
            do{
                System.out.println("Insert position: ");
                String ourPosition = scanner.nextLine();
                Integer ourPositionNumber = Integer.valueOf(ourPosition);
                status = board.addMove(ourPositionNumber, "O");
                if (status) {
                    socketOut.write(ourPositionNumber + "\n");
                    socketOut.flush();
                } else {
                    System.out.println("Invalid position!");
                }
            } while (!status);
        }
    }
}
