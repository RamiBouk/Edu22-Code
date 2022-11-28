package tp3_2;
import java.util.*;
public class ListEvents{

    Vector events;
    public ListEvents(){
        events=new Vector();
    }
    public void addEvent(Event newEvent){
        int insertIndex=0;
        while(insertIndex<events.size()){
            Event e=(Event) events.elementAt(insertIndex);
            if(e.getTime()>newEvent.getTime())
                break;
            insertIndex++;
        }

        events.insertElementAt(newEvent,insertIndex);
    }

}
