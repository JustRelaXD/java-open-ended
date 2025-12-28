import java.util.*;

class TooEarlyToApply extends Exception{
    TooEarlyToApply(){
        super("Too early to apply(must be at least 18)");
    }
}

class TooLateToApply extends Exception{
    TooLateToApply(){
        super("Too early to apply(must be at least 18)");
    }
}

public class javaPrg5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Enter your name: ");
            String name = sc.next();
            System.out.println("Enter your role: ");
            String role = sc.next();
            System.out.println("Enter your sgr: ");
            int age = sc.nextInt();
            if(age<18){
                throw new TooEarlyToApply();
            }
            else if(age>40){
                throw new TooLateToApply();
            }
            else{
                System.out.println("Application accepted");
                System.out.println("Name: "+name);
                System.out.println("Role: "+role);
                System.out.println("Age: "+age);
            }
        }catch(TooEarlyToApply | TooLateToApply e){
            System.out.println(e.getMessage());
        }
        catch(InputMismatchException e){
            System.out.println("Invalid input");
        }finally{
            sc.close();
        }

    }
}