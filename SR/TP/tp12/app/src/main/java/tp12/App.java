/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package tp12;

import java.io.IOException;

import java.math.BigInteger;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.lang.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner keyboard= new Scanner(System.in);
        if(args[0].equals("tp2_1")){ 
            if(args[1].equals("p1")){

                // PROCESSUS P1
                DatagramSocket socket=new DatagramSocket(20001);
                keyboard.nextLine();
                byte[] buf= new byte[512];

                for(int i=0;i<90;i++){
                    Thread.sleep(2000);

                    //sending
                    String message=String.valueOf(i);
                    buf=message.getBytes(); 
                    InetAddress adress=InetAddress.getByName("127.0.0.1");
                    DatagramPacket packet =new DatagramPacket(buf,buf.length,adress,20002);
                    socket.send(packet);

                    //receiving
                    byte[] buf2= new byte[512];
                    DatagramPacket packet2 =new DatagramPacket(buf2,buf2.length);
                    socket.receive(packet2);
                    String content=  new String(buf2,0,packet2.getLength());
                    System.out.println("received: ["+content+"]");

                    
                }
            }
            else if(args[1].equals("p2")){

                // PROCESSUS P1
                DatagramSocket socket=new DatagramSocket(20002);
                keyboard.nextLine();
                byte[] buf= new byte[512];

                for(int i=90;i>0;i--){
                    Thread.sleep(5000);
                    //sendingu

                    String message=String.valueOf(i);
                    buf=message.getBytes(); 
                    InetAddress adress=InetAddress.getByName("127.0.0.1");
                    DatagramPacket packet =new DatagramPacket(buf,buf.length,adress,20001);
                    socket.send(packet);
                    
                    // receivina
                    byte[] buf2= new byte[512];
                    DatagramPacket packet2 =new DatagramPacket(buf2,buf2.length);
                    socket.receive(packet2);
                    String content=  new String(buf2,0,packet2.getLength());
                    System.out.println("received: ["+content+"]");

                    
            }

            }
        }
        if(args[0].equals("tp2_2")){ 
            if(args[1].equals("p1")){

                // PROCESSUS P1
                Client client=new Client(20001);
                String content;
                int T=5;
                for(int i=0;i<10;i++){
                    Thread.sleep(T*1000);
                    client.send(String.valueOf(i),"127.0.0.1",20002);
                    content=client.receive();
                    
                }
            }
            else if(args[1].equals("p2")){

                // PROCESSUS P2
                Client client=new Client(20002);
                String content;
                int T=10;
                for(int i=0;i<10;i++){
                    client.send(String.valueOf(i),"127.0.0.1",20001);
                    content=client.receive();
                }
            }

        }
        //
        //for executing p2
        //

        if(args[0].equals("p2")){
            System.out.println("=================P2==============");
            Client client=new Client(4446);

            if(args[1].equals("1")){
                System.out.println("=================P2==============");
                client.send("hello i am process p2 at "+ client.getPort(),"127.0.0.1",4445);
                client.receive();}

            if(args[1].equals("2")){

                int i=1;
                while(true){
                    System.out.println("sending "+i);
                    client.send(String.valueOf(i),"127.0.0.1",4445);
                    i++;
                }
            }

            if(args[1].equals("3")){

                int i=1;
                while(true){
                    System.out.println("sending "+i);
                    client.send(String.valueOf(i),"192.168.117.49",4445);
                    i++;
                }
            }
        }
        //
        //for exectuing p1
        //
        if (args[0].equals("p1")) {
            System.out.println("=================P1==============");

            Client client=new Client(4445);

            int i =0;
            
            if(args[1].equals("1")){
                // a thread to wait asyn for a message
                client.receive();
                client.send("hello i am process p1 at "+client.getPort() ,"127.0.0.1",4446);
                //            System.out.println("waiting for 9 seconds");
                ///           TimeUnit.SECONDS.sleep(9);
            }

            if(args[1].equals("2")){
                while(true ){
                    i=Integer.valueOf(client.receive());
                    System.out.println("the results is :"+i*i);
                }
            }
            if(args[1].equals("5")){
                while(true ){
                    i=Integer.valueOf(client.receive());
                    System.out.println("the results is :"+i*i);
                }
            }
                
            if(args[1].equals("3"))
                while(true ){
                    
                    client.receive(); 
                    String message=keyboard.nextLine();
                    client.send(message,"192.168.117.163",4447);
                }
                
            }
        }
    }

