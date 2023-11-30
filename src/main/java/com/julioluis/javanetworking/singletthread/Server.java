package com.julioluis.javanetworking.singletthread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket=new ServerSocket(9999);

        QuoteService quoteService=new QuoteService();

       while (true) {
           Socket socket=serverSocket.accept();

           InputStream in=socket.getInputStream();
           OutputStream out=socket.getOutputStream();

           byte request[]=new byte[100];
           in.read(request);

           String product=new String(request).trim();
           String price=quoteService.getQuote(product);

           if (Objects.isNull(price)) {
               price="Invalid Price";
           }

           out.write(price.getBytes());

           socket.close();
       }
    }
}
