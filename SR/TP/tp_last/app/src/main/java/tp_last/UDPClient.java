package tp_last;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class UDPClient{
    public static void main1()throws Exception{
            while(true){
            
                System.out.println("donner loperation: +-*/");
                Scanner clavier =new Scanner(System.in);
                String op=clavier.nextLine();
                System.out.println("kdonner le premier nombre");
                int N1= clavier.nextInt();
                System.out.println("donner le deuxieme nombre");
                int N2=clavier.nextInt();
                String operation=N1+":"+op+":"+N2;
                DatagramSocket ds =new DatagramSocket(30000);
                InetAddress AdrClient=InetAddress.getByName("127.0.0.1");
                byte[] p=operation.getBytes();
                DatagramPacket dp = new DatagramPacket(p,p.length,AdrClient,31000);
                ds.send(dp);
                Thread.sleep(1000);
                byte[] tampon =new byte[1000];
                DatagramPacket dp1=new DatagramPacket(tampon,tampon.length);
                ds.receive(dp1);
                String s = new String(dp1.getData());
                System.out.println(s);
                ds.close();
            }
        }
}





