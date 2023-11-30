package com.julioluis.javanetworking.singletthread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket=new ServerSocket(9999);

       while (true) {
           System.out.println("waiting for clients");
           Socket socket=serverSocket.accept();

           new ServiceThread(socket).start();

       }
    }
}
