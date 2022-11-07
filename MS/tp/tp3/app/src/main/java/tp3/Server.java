package tp3;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.lang.*;        
public class Server{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    private Boolean busy;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public Server(){
        this.busy=false;    
    }
    public void serve(Client client){
        System.out.print("client id:");
        System.out.println(client.id);
        System.out.print("the curent time:  ");
        System.out.println(client.tempsArrivee);
        System.out.print("The service time: ");
        System.out.println(client.dureeService);

        if(busy){
            System.out.println(ANSI_RED+"the process is rejected"+ANSI_RESET);
            return;
        }
        busy=true;
        System.out.println(ANSI_GREEN+"the process is Accepted"+ANSI_RESET);
        try {
        Thread.sleep((int)(client.dureeService*1000));   
        } catch(Exception e){
            e.printStackTrace();
        }
        busy=false;


    }
}
