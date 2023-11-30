package com.julioluis.javanetworking.singletthread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket socket= new Socket("127.0.0.1",9999);

        InputStream in=socket.getInputStream();
        OutputStream out=socket.getOutputStream();

        out.write("c".getBytes());

        byte response []=new byte[100];
        in.read(response);

        System.out.println(new String(response).trim());
    }
}
