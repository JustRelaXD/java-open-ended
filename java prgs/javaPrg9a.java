import java.util.Scanner;

public class StringMethods {
   public static void main(String[] args) {
    int choice;
    String s1,s2;

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter string 1: ");
    s1 = sc.nextLine();
    System.out.println("Enter string 2: ");
    s2 = sc.nextLine();

    do{
        System.out.println("Choose the operation");
        System.out.println("1. Equals ");
        System.out.println("2. Equals (Case-Insenstive)");
        System.out.println("3. startswith");
        System.out.println("4. endswith");
        System.out.println("5. Compare To");
        System.out.println("6. Exit");
        System.out.println("Enter choice: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1: if(s1.equals(s2)){
                        System.out.println("Strings are equal (Case Sensitive)");
                    }
                    else{
                        System.out.println("Strings are not equal (Case Sensitive)");
                    }
                    break;
            case 2: if(s1.equalsIgnoreCase(s2)){
                        System.out.println("Strings are equal (Case Insensitive)");
                    }
                    else{
                        System.out.println("Strings are not equal (Case Insensitive)");
                    }
                    break;
            case 3: if(s1.startsWith(s2)){
                        System.out.println("String 1 starts with string 2");
                    }
                    else{
                        System.out.println("String 1 does not start with string 2");
                    }
                    break;
            case 4: if(s1.endsWith(s2)){
                        System.out.println("String 1 ends with string 2");
                    }
                    else{
                        System.out.println("String 1 does not end with string 2");
                    }
                    break;
            case 5: int result=s1.compareTo(s2);
                    if(result==0){
                        System.out.println("Strings are equal ");
                    }
                    else if(result>0){
                        System.out.println("String 1 is greater than string 2");
                    }
                    else if(result<0){
                        System.out.println("String 2 is greater than string 1");
                    }
                    break;
            case 6: System.out.println("Exiting");
                    break;
            default:System.out.println("Invalid input");
                    break;
        }
    }while(choice!=6);

   } 
}