package tp_last ;
import java.io.*;
import java.net.SocketException;

public class App{
    public static void main (String[] args)throws Exception {
        if(args[0].equals("1"))
        Process.main1();
        if(args[0].equals("2")){
            if(args[1].equals("s"))
                UDPServer.main1(); 
            if(args[1].equals("c"))
                UDPClient.main1(); 
        }
        }
    }
