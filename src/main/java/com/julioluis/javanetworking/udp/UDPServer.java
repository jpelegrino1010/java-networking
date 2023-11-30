package com.julioluis.javanetworking.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket=new DatagramSocket(8989);
        DatagramPacket packet=new DatagramPacket(new byte[1000],1000);

        socket.receive(packet);

        System.out.println(new String(packet.getData()));
        System.out.println("Obtained from IP - "+ packet.getAddress());
        System.out.println("Obtained from port - "+ packet.getPort());

        socket.close();

    }
}
