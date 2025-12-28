import java.util.Scanner;

public class SB {
    public static void main(String[] args) {
        int choice;
        String str;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter initial string : ");
        str = sc.nextLine();
        StringBuffer sb = new StringBuffer(str);

        do{
            System.out.println("\nChoose the operation");
            System.out.println("1. Insert ");
            System.out.println("2. Delete");
            System.out.println("3. Append");
            System.out.println("4. Reverse");
            System.out.println("5. Capacity");
            System.out.println("6. Exit");
            System.out.println("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: System.out.println("Enter the position to insert string: ");
                        int position = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter the string to insert: ");
                        String insStr=sc.nextLine();
                        sb.insert(position,insStr);
                        System.out.println("After Insert: "+ sb);
                        break;
                case 2: System.out.println("Enter the starting index: ");
                        int start = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter the ending index: ");
                        int end = sc.nextInt();
                        sc.nextLine();
                        sb.delete(start, end);
                        System.out.println("After Delete: "+ sb);
                        break;
                case 3: sc.nextLine();
                        System.out.println("Enter the string to append: ");
                        String appStr=sc.nextLine();
                        sb.append(appStr);
                        System.out.println("After Append: "+ sb);
                        break;
                case 4: sb.reverse();
                        System.out.println("After Reverse: "+ sb);
                        break;
                case 5: System.out.println("Capacity: "+ sb.capacity());
                        break;
                case 6: System.out.println("Exiting");
                        break;
                default:System.out.println("Invalid input");
                        break;
            }
        }while(choice!=6);
    }
}