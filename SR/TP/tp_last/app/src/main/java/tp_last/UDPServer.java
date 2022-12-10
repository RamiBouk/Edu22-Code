package tp_last;
import java.net.*;
import java.io.*;

public class UDPServer{
    public static void main1()throws Exception{
       DatagramSocket ds =new DatagramSocket(31000);
        while(true){
            byte[] tampon = new byte[100];
            DatagramPacket dp = new DatagramPacket(tampon,tampon.length);
            ds.receive(dp);
            new ClientThread(ds,dp);
        }
    }
}

