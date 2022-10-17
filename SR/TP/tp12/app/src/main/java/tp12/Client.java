package tp12;
import java.util.Arrays;

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
    int counter=0;
    public int getPort() {
        return port;
    }

    public Client(int port)throws Exception{
        this.port=port;
        socket=new DatagramSocket(port);
    }
    public Client(String ip, int port){



    }
    // 
    // receiving a string 
    //
    public String receive() throws Exception  {
        buf= new byte[512];
        String content="error";
        DatagramPacket packet =new DatagramPacket(buf,buf.length);
        //Thread thread = new Thread(()  -> {
        System.out.println("waiting for message");
        socket.receive(packet);

        content= new String(buf,0,packet.getLength());
        System.out.println("received: ["+content+"] from "+packet.getAddress()+":"+packet.getPort());
        running=false;
        counter++;
        return content;
        }
    //
    // sending a string 
    //
    public void send(String message, String ip,int port) throws IOException  {
        byte[] buf=message.getBytes(); 

        InetAddress adress=InetAddress.getByName(ip);
        DatagramPacket packet =new DatagramPacket(buf,buf.length,adress,port);
        System.out.println("sending message");
        socket.send(packet);
        System.out.println("sent: ["+message+"] to "+ip+":"+port);

    }

    //
    //receiving an int 
    //
    public int receiveInt() throws Exception  {
        buf= new byte[1];
        DatagramPacket packet =new DatagramPacket(buf,buf.length);
        int content=8;
        System.out.println("waiting for message");
        socket.receive(packet);
        content= new BigInteger(buf).intValue();
        System.out.println("received: ["+content+"] from "+packet.getAddress()+":"+packet.getPort());
        running=false;
        return content;

    }
    //
    // sending an int 
    //
    public void send(int message, String ip,int port) throws IOException  {
        byte[] buf=BigInteger.valueOf(message).toByteArray(); 
        InetAddress adress=InetAddress.getByName(ip);
        DatagramPacket packet =new DatagramPacket(buf,buf.length,adress,port);
        socket.send(packet);
        System.out.println("sent:  ["+new BigInteger(buf).intValue()+"] to "+ip+":"+port);

    }

    public void close(){
        socket.close();
    }
    }
