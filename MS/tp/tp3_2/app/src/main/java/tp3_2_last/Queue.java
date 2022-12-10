package tp3_2;
import java.util.*;
public class Queue{
    Vector<Client> lesClients;
    public Queue(){
        lesClients=new Vector();
    }
    public void addClient(Client c){
        lesClients.addElement(c);
    }
    public void removeLast()throws Exception{
        lesClients.remove(lesClients.size()-1);
    }
    public Client nextClient()throws Exception{
        return lesClients.lastElement();
    }
    public Boolean isEmpty(){
        return lesClients.size()==0;
    }
}
