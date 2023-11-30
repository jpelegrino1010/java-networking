package com.julioluis.javanetworking.singletthread;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Objects;

public class ServiceThread extends Thread{

    private Socket socket;
    QuoteService quoteService=new QuoteService();

    public ServiceThread(Socket socket) {
        this.socket=socket;
    }

    @Override
    public void run() {
       try {
           InputStream in=socket.getInputStream();
           OutputStream out=socket.getOutputStream();
           System.out.println("Waiting for information");
           byte request[]=new byte[100];
           in.read(request);

           String product=new String(request).trim();
           String price=quoteService.getQuote(product);

           if (Objects.isNull(price)) {
               price="Invalid Price";
           }

           out.write(price.getBytes());

           socket.close();
       }catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
}
