
package tp3_2;
public class Client{
    protected int indent;
    protected double arrivalTime;
    protected double serviceTime;
    public Client(double arrivalTime,double serviceTime){
        this.arrivalTime=arrivalTime;
        this.serviceTime=serviceTime;
    }
    public double getArrivalTime(){
        return this.arrivalTime;
    }
    public double getServiceTime(){
        return this.serviceTime;
    }
}
