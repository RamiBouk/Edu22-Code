/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package grad;
import java.util.Scanner;

public class App {
    private static int func(int x) {
          int y =0; 
           double rand;
            rand=Math.random();     
            switch (x) {
                case 1:
                   if(rand<1/3.)
                       y=2;
                   else 
                       y=3;
                    break;

                case 2:
                   if(rand<1/3.)
                       y=3;
                   else 
                       y=2;
                    break;

                case 3:
                   if(rand<1/2.)
                       y=1;
                   else 
                       y=4;
                    break;

                case 4:
                    y=3;   
                    break;

                    default:
                    break;
            }
       return y;
    }
    public static void main(String[] args) {
        int n=5,i=0,x=1 ;
        // declaration init i
        Scanner keyboard=new Scanner(System.in);
        x=keyboard.nextInt();
        System.out.print(x);
        keyboard.close(); 
        // tab counter
        int [] counter={0,0,0,0};
        
        while(i<n){
            System.out.println("X"+i+": "+x);
            counter[x-1]++;
            x=func(x); 
            i++;
        }
            System.out.println("counter totale:");
            for(int j=0;j<counter.length;j++)
                System.out.println("x"+(j+1)+": "+counter[j]);
            System.out.print(counter);
    }

}
