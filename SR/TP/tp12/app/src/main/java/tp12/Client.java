package tp12;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Client
 */
public class Client {

    private DatagramSocket socket;
    private InetAddress destAddress;
    private  int port;
    public Client(int port)throws IOException{
        this.port=port;
        socket=new DatagramSocket(port);
    }
    public void receive() throws IOException  {
        byte[] buf= new byte[512];
        // definingh te data gram 
        DatagramPacket packet =new DatagramPacket(buf,buf.length);
        System.out.println("waiting for message");
        socket.receive(packet);
        String content= new String(buf,0,packet.getLength());
        System.out.print("received: "+content);
        
    }
    
    public void send(String message, String ip,int port) throws IOException  {
        byte[] buf=message.getBytes(); 
       
        InetAddress adress=InetAddress.getByName(ip);
        // definingh te data gram 
        System.out.println(port);
        DatagramPacket packet =new DatagramPacket(buf,buf.length,adress,port);
        System.out.println("sending message");
        socket.send(packet);
        System.out.print("sent: "+message);
        
    }
}
