package com.julioluis.javanetworking.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPClient {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket=new DatagramSocket();

        String message="Hello from socket packet";
        byte data []= message.getBytes();

        DatagramPacket packet=new DatagramPacket(data,data.length, InetAddress.getLocalHost(),8989);
        socket.send(packet);

        socket.close();
    }
}
