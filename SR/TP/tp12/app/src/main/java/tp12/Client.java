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
    public String receive() throws Exception  {
        buf= new byte[512];
        String content="error";
        DatagramPacket packet =new DatagramPacket(buf,buf.length);
        //Thread thread = new Thread(()  -> {
            try {
                while(running){
                System.out.println("waiting for message");
                socket.receive(packet);
                content= new String(buf,0,packet.getLength());
                System.out.println(counter+"received: ["+content+"] from "+packet.getAddress()+":"+packet.getPort());
                running=false;
                counter++;
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        //});
       // thread.start();
       running=true;
       return content;
    }
    
    public int receiveInt() throws Exception  {
        buf= new byte[512];
        byte[] buf2=new byte[512];
        DatagramPacket packet =new DatagramPacket(buf,buf.length);
        //Thread thread = new Thread(()  -> {
            try {
                while(running){
                System.out.println("waiting for message");
                socket.receive(packet);
               int content= new BigInteger(buf2).intValue();
                System.out.println(counter+"received: ["+content+"] from "+packet.getAddress()+":"+packet.getPort());
                running=false;
                if(Arrays.equals(buf,buf2))
                    System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaaa");
                counter++;
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        //});
       // thread.start();
       running=true;
       return 89;

    }

    public void send(int message, String ip,int port) throws IOException  {
        byte[] buf=BigInteger.valueOf(message).toByteArray(); 
        InetAddress adress=InetAddress.getByName(ip);
        DatagramPacket packet =new DatagramPacket(buf,buf.length,adress,port);
        System.out.println("sending message");
        socket.send(packet);
        System.out.println("sent: lkajdl; ["+new BigInteger(buf).intValue()+"]");
        System.out.println((buf));

    }
    public void send(String message, String ip,int port) throws IOException  {
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
