package com.sda.chat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by RENT on 2017-06-26.
 */
public class ChatConnectionFacade {

    public ChatConnectionFacade(Scanner in, BufferedWriter out) {
        this.in = in;
        this.out = out;
    }

    private Scanner in;

    private BufferedWriter out;

    private String nickname;

    public ChatConnectionFacade(Scanner in, BufferedWriter out, String nickname) {
        this.in = in;
        this.out = out;
        this.nickname = nickname;
    }

    public void write(String message) throws IOException {
        System.out.println(nickname + ": " + message);
        out.write(message + "\n");
        out.flush();
    }

    public String read() {
        return in.nextLine();
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }
}
