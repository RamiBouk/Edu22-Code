package tp_last;
import java.net.*;
import java.io.*;

public static void UDPServer{
    public static void main1()throws Exception{
        while(true){
            DatagramSocket ds =new DatagramSocket(8000);
            byte[] tampon = new byte[100];
            DatagramPacket df = new DatagramPacket(tampon,tampon.length);
            ds.receive(dp);
            new ClientThread(ds,dp);
        }
    }
}

