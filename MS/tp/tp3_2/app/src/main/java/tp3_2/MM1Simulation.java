
package tp3_2;
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
    }

    public double expo(double taux){
        return -Math.log(Math.random())/taux;
    }

    public void simulate(){
        // to implement
        double Ds,Tint,Fs=0;
        lambda=0.5;mu=1;
        int serveur=0;
        double t=0; int i=1;
        while (i<=60) {
            System.out.println("le client : "+i+" arrive autemps : "+t);
            if(serveur==0) {
                serveur=1;
                Ds=expo(mu);
                Fs=t+Ds;
                System.out.println("Accepté ** sa durée deservice ="+Ds+" et il termine son service à : "+Fs+"\n");
            }
            else System.out.println("Rejeté ** \n");
            Tint=expo(lambda);
            t=t+Tint;
            if(t>Fs) serveur=0;
            i++;


        }
    }


    }
