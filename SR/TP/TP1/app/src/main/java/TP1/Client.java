package TP1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class Client  {
      //  adresses and ports
        String hostname;
        int port ; 
        InetAddress address;
        DatagramSocket socket; 
        DatagramPacket request; 
        byte[] buffer = new byte[512];


        public Client( String hostname,int port){
          this.hostname=hostname;
          this.port=port;
        }

        
        public void run() throws UnknownHostException, SocketException {
            
        address = InetAddress.getByName(hostname);
        // 
        // UDP sockets
        //
        socket = new DatagramSocket();
        //
        // USP packet
        //
        request = new DatagramPacket(buffer, buffer.length, address, port); 
        try {
            
        //
        // send request
        //
        System.out.println("sending a request");
        socket.send(request);
        //
        // receive response
        //
        DatagramPacket response = new DatagramPacket(buffer, buffer.length);
        socket.receive(response);
        //
        // print response
        //
        String quote = new String(buffer, 0, response.getLength());
        System.out.println(quote);
        
        } catch (SocketTimeoutException ex) {
            System.out.println("Timeout error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Client error: " + ex.getMessage());
            ex.printStackTrace();
        }}
}
