package tp3_2;
public class Event{
    protected int type;
    protected double instant;

    public Event(int type,double time){
        this.type=type;
        this.instant=time;
    }

    public int getType(){
        return type;
    }
    public double getTime(){
        return instant;
    }
}
