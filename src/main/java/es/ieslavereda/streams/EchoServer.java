package es.ieslavereda.streams;

import java.net.*;
import java.io.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {

        int portNumber = 8000;
        String IP = "10.13.1.1";

        try (
                ServerSocket serverSocket = new ServerSocket(8000)
        ) {
            while (true){
                new Thread(new ChannelManager(serverSocket.accept())).start();
            }

        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
