/* This Java source file was generated by the Gradle 'init' task.
 */
package tp2;
import java.math.BigInteger;
import java.util.Scanner;

public class App {
    public static double multi1D(double[] A,double[]B){
        double sum =0;
        for(int i =0;i<=B.length-1;i++){
            sum+=A[i]*B[i];
        }
        return sum ;
    }
    public static double prob(double[][]a,double[][]b,int[] traj){
        double res=1;
        double s=0;
        for(int j=0 ; j<traj.length-1;j++) {
            res=b[0][j]*a[j][traj[0]-1];
            for(int i=0 ; i<traj.length-1;i++) 
                res=res*a[traj[i]-1][traj[i+1]-1];  
            }{
        }
            
        return res;
    }
    public static double[][] multi(double[][] A, double[][] B){
        double [][] sol=new double[A.length][B[0].length];
        double sum;
        int b =B.length;
        double [] Bc=new double[b];
        for(int i =0;i<A.length;i++){
            for (int j = 0; j < B[i].length; j++) {
                sum=0;
                for (int j2 = 0; j2 < B.length; j2++) {
                    Bc[j2]=B[j2][j];
                } 
                sol[i][j] =multi1D(A[i], Bc);
            }}

        return sol;
    }
    public static double[][] pow(double[][] A, int n){
        double[][] res=A;
        for (int i = 1; i < n; i++) {
            res=multi(A, res); 
        }
        return res;
    }
    public static void show(double[][] A){
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j]+" "); 
            } 
            System.out.println("|");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        double [][] a ={{.5,.5,0},{0.5,1/12.,5./12},{0,0,1}};
        double [][] b ={{0.2,0.3,0.5}};
        int n=0;
        Boolean okey=false;
        Scanner keyboard =new Scanner(System.in);

        //String flag=keyboard.nextLine();
        String flag="2";
        /*


           while(b[0][0]+b[0][1]!=1){
           System.out.println("donner X[0]:");
           b[0][0]=Double.valueOf(keyboard.nextLine());
           System.out.println("donner X[1]:");
           b[0][1]=Double.valueOf(keyboard.nextLine());
           if(b[0][0]+b[0][1]!=1)
           System.out.println("invalide matrix");
           }
           for (int i = 0; i < a.length; i++) {
           while(a[i][0]+a[i][1]+a[i][2]!=1){
           for (int j = 0; j < a.length; j++) { 
           System.out.println("donner P["+i+"]["+j+"}:");
           a[i][j]=Double.valueOf(keyboard.nextLine());
           }
           if(a[i][0]+a[i][1]+a[i][2]!=1)
           System.out.println("invalide matrix");
           }

           }
           */
        if(flag=="1"){
            System.out.println("X0=");
            show(b);
            System.out.println("P=");
            show(a);
            System.out.println("donner D:");
            int d=Integer.valueOf(keyboard.nextLine());
            System.out.println("donner n:"); 
            n=Integer.valueOf(keyboard.nextLine());
            System.out.println(multi(b,pow(a,n))[0][d-1]);
        }
        if(flag=="2"){
            System.out.println("X0=");
            show(b);
            System.out.println("P=");
            show(a);
           // int dest=Integer.valueOf(keyboard.nextLine());
            double res=0;
            int[] traj={1,2,3};
            res=prob(a,b, traj);
            System.out.println(res);
        }
        //s
        //how(multi(b,pow(a,n)));
        //show(a);
        // show(pow(a,1));
        //show(pow(a,2));
        keyboard.close();
    }
}
