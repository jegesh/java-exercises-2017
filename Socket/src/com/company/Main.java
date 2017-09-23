package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(5000);
            Socket client = null;

            while (true){

                System.out.println("waiting...");
                    client = serverSocket.accept(); // block method - wait for something to happened - connected
                System.out.println("client connected");
                System.out.println(client.getInetAddress().getHostName() + "connected");
                new ClientThread(client).start();


            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
