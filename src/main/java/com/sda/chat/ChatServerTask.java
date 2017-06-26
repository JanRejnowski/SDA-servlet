package com.sda.chat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by RENT on 2017-06-26.
 */
public class ChatServerTask implements Runnable {

    private ChatConnectionFacade yourConnection;

    private ChatUsersStorage storage;

    public ChatServerTask(Socket socket, ChatUsersStorage storage) throws IOException {
        Scanner in = new Scanner(socket.getInputStream());
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.yourConnection = new ChatConnectionFacade(in, out);

        this.storage = storage;
    }

    @Override
    public void run() {
        String nickname = yourConnection.read();
        yourConnection.setNickname(nickname);
        boolean add = storage.add(nickname, yourConnection);
        if (add) {
            boolean flag = true;
            while (flag) {
                String input = yourConnection.read();
                String nickToSend = input.substring(0, input.indexOf(" "));
                ChatConnectionFacade destinationConnection = storage.get(nickToSend);
                try {
                    destinationConnection.write(input.substring(input.indexOf(" ")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                yourConnection.write("Nickname already in use");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
