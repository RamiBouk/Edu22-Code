package TP1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Server
 */
public class Server extends Thread {

    private DatagramSocket socket;
    private boolean running;
    private final byte[] buf = new byte[256];

    public Server() {
        try {
            socket = new DatagramSocket(4445);
        } catch (final SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void run() {
        running = true;
            DatagramPacket packet  = new DatagramPacket(buf, buf.length);
            System.out.println("waiting for a messag");
            socket.receive(packet);
        final InetAddress address = packet.getAddress();
        final int port = packet.getPort();
        packet = new DatagramPacket(buf, buf.length, address, port);
        final String received 
            = new String(packet.getData(), 0, packet.getLength());
        System.out.println("received:"
                );
        System.out.print(received);
        if (received.equals("end")) {
            running = false;
            continue;
        }
    }
    socket.close();
}
}
