package tp3;
public class Client{
    protected int indent;
    protected double tempsArrivee;
    protected double dureeService;
    public Client(int id,double arrivalTime, double serviceTime){
        this.indent=id;
        this.tempsArrivee= arrivalTime;
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
