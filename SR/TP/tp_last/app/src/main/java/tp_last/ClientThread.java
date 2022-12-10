package tp_last;
import java.net.*;
import java.io.*;

public class ClientThread extends Thread{
    DatagramSocket ds ;
    DatagramPacket dp ;
    public ClientThread(DatagramSocket ds ,DatagramPacket dp){
        this.ds=ds;
        this.dp=dp;
        this.start();
    }
    public void run(){
        String input = new String(dp.getData());
        String[] in =input.split("[;]");
        double temp=0;
        if(in[1].matches("[+]") temp=Double.valueOf(in[0]+double.valueOf(in[2]);
        if(in[1].matches("[-]") temp=Double.valueOf(in[0]-double.valueOf(in[2]);
        if(in[1].matches("[*]") temp=Double.valueOf(in[0]*double.valueOf(in[2]);
        if(in[1].matches("[/]") temp=Double.valueOf(in[0]/double.valueOf(in[2]);
        String r ="res: " +temp +"by"+Thread.currentThread().getName();
        byte[] m =r.getBytes();
        InetAddress AdrServer =InetAddress.getByName("127.0.0.1");
        DatagramPacket dp = new DatagramPacket(m,m.length,AdrServer,7000);
        ds.send(dp);
    }
}

