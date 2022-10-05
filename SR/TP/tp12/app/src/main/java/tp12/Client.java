package tp12;

import java.io.IOException;
import java.math.BigInteger;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Client
 */
public class Client {
    private Boolean running=true;
    private DatagramSocket socket;
    private InetAddress destAddress;
    private  int port;
    private byte[] buf;
    public int getPort() {
        return port;
    }
    public Client(int port)throws Exception{
        this.port=port;
        socket=new DatagramSocket(port);
    }
    public void receive() throws Exception  {
        buf= new byte[512];
        DatagramPacket packet =new DatagramPacket(buf,buf.length);
        //Thread thread = new Thread(()  -> {
            try {
                while(running){
                System.out.println("waiting for message");
                socket.receive(packet);
                String content= new String(buf,0,packet.getLength());
                System.out.println("received: ["+content+"] from "+packet.getAddress()+":"+packet.getPort());
                running=false;
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        //});
       // thread.start();

    }
    
    public int receiveInt() throws Exception  {
        buf= new byte[512];
        DatagramPacket packet =new DatagramPacket(buf,buf.length);
        //Thread thread = new Thread(()  -> {
            try {
                while(running){
                System.out.println("waiting for message");
                socket.receive(packet);
                String content= new String(buf,0,packet.getLength());
                System.out.println("received: ["+content+"] from "+packet.getAddress()+":"+packet.getPort());
                running=false;
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        //});
       // thread.start();
       return 0;

    }

    public void sendInt(int message, String ip,int port) throws IOException  {
        byte[] buf=BigInteger.valueOf(message).toByteArray(); 
        InetAddress adress=InetAddress.getByName(ip);
        DatagramPacket packet =new DatagramPacket(buf,buf.length,adress,port);
        System.out.println("sending message");
        socket.send(packet);
        System.out.println("sent: ["+message+"]");

    }
    public void sendString(String message, String ip,int port) throws IOException  {
        byte[] buf=message.getBytes(); 

        InetAddress adress=InetAddress.getByName(ip);
        DatagramPacket packet =new DatagramPacket(buf,buf.length,adress,port);
        System.out.println("sending message");
        socket.send(packet);
        System.out.println("sent: ["+message+"]");

    }
    public void close(){
        socket.close();
    }
}
