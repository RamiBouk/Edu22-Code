
package tp3_2;
import java.lang.*;
public class MM1Simulation{
    double lambda;
    double mu;
    ListEvents list=new ListEvents();
    Queue q=new Queue();
    double t;

    public MM1Simulation(double lambda,double mu){
        this.lambda=lambda;
        this.mu=mu;
    }

    public double expo(double taux){
        return -Math.log(Math.random())/taux;
    }
    public void new_simulate()throws Exception{
        System.out.println("hey");
        double t=0 ,tn=0;
        Event e=new Event(1,0);
        list.addEvent(e);
        int i=0;
        while(i<60){
            e=list.getNextEvent();
            t=e.instant;
            if(e.type==1){
                tn=t+expo(lambda);
                double  s=expo(mu);
                Event en=new Event(1,tn);
                list.addEvent(en);
                Client c =new Client(t,s);
                q.addClient(c);
                System.out.println("entering at "+t+" service duration "+s +" \n");
                Event en2=new Event(2,t+s);
                list.addEvent(en2);


                
                // if last
                // ajouteer event corespending to them lieaving with t+serice as exist time 
                //


            }
            if(e.type==2){
                System.out.println("leaving at :"+e.instant);
                q.removeLast();

                if(q.isEmpty()){
                    tn=t+expo(mu);
                    list.addEvent(new Event(1,tn));
                }


            }
            i++;
        }
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
