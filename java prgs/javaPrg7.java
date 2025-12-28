import java.util.*;

class squareThread extends Thread{
    int n;
    squareThread(int n){
        this.n=n;
        this.start();
    }

    public void run(){
        System.out.println("Square of "+n+":"+n*n);
    }
}

class cubeThread extends Thread{
    
    int n;
    cubeThread(int n){
        this.n=n;
        this.start();
    }

    public void run(){
        System.out.println("Cube of "+n+":"+n*n*n);
    }
}

public class javaPrg7 {
    public static void main(String args[]){
        Random rand = new Random();
        for(int i=0;i<10;i++){
            int n = rand.nextInt(10);
            System.out.println("Random :"+n);
            if(n%2==0){
                squareThread t1=new squareThread(n);
            }
            else{
                cubeThread t2 = new cubeThread(n);
            }
        
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }     
        }
    }
}