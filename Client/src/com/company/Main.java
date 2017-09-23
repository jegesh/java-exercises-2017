package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        OutputStream out;

        String ip = "10.0.0.5";
        int port = 5000;

        try {
            Socket client = new Socket(ip, port);
            Scanner scanner = new Scanner(System.in);
            out = client.getOutputStream();

            while (true){

                String  message = scanner.nextLine();

                checkMessage(message);

                out.write(message.getBytes());
                out.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void checkMessage(String message) {

        if (message.equals("end")){

            System.exit(1);
        }
    }


}
