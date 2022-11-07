package tp3;
public class Client{
    protected static int indent=0;
    protected int id;
    protected double tempsArrivee;
    protected double dureeService;
    public Client(double arrivalTime, double serviceTime){
        if(indent==0)
            this.tempsArrivee=0;
        else
        this.tempsArrivee= arrivalTime;
        this.id=Integer.valueOf(indent++);
        this.dureeService=serviceTime;
    }
    public int getClientId(){
        return indent;
    }
    public double getArrivalTime() {
        return tempsArrivee;
    }
    public double getServiceTime() {
        return dureeService;
    }
}
