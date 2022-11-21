import java.lang.*;
public class MM1Simulation{
    double lambda;
    double mu;
    ListEvents list;
    Queue q;
    double t;

    public MM1Simulation(double lambda,double mu){
        this.lambda=lambda;
        this.mu=mu;
        q = new Queue();
        list = new ListEvents();
    }

    public double expo(double taux){
        return -Math.log(Math.random())/taux;
    }

    public void simulate(double simLength){
        // to implement
        for(int i=0;i<simLength;i++)
            
        
    }
    
    public static void main(String[] arg){
        MM1Simulation s=new MM1Simulation(0.5,1.0);
        s.simulate(10000);
    }
}
