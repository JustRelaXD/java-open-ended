import java.util.Scanner;

class ElectricityBill {
    int consumerNo;
    String consumerName;
    int prevReading;
    int currReading;
    String type;

    ElectricityBill(int consumerNo, String consumerName, int prevReading, int currReading, String type) {
        this.consumerNo = consumerNo;
        this.consumerName = consumerName;
        this.prevReading = prevReading;
        this.currReading = currReading;
        this.type = type.toLowerCase();
    }

    int getUnits() {
        return currReading - prevReading;
    }

    double calculateBill() {
        int units = getUnits();
        double amount = 0;

        if (type.equals("domestic")) {
            if (units <= 100)
                amount = units * 1;
            else if (units <= 200)
                amount = (100 * 1) + (units - 100) * 2.5;
            else if (units <= 500)
                amount = (100 * 1) + (100 * 2.5) + (units - 200) * 4;
            else
                amount = (100 * 1) + (100 * 2.5) + (300 * 4) + (units - 500) * 6;
        } 
        
        else if (type.equals("commercial")) {
            if (units <= 100)
                amount = units * 2;
            else if (units <= 200)
                amount = (100 * 2) + (units - 100) * 4.5;
            else if (units <= 500)
                amount = (100 * 2) + (100 * 4.5) + (units - 200) * 6;
            else
                amount = (100 * 2) + (100 * 4.5) + (300 * 6) + (units - 500) * 7;
        }
        return amount;
    }

    void displayBill() {
        System.out.println("\nConsumer Details");
        System.out.println("Consumer No: " + consumerNo);
        System.out.println("Consumer Name: " + consumerName);
        System.out.println("Type of EB connection: " + type);
        System.out.println("Previous Reading: " + prevReading);
        System.out.println("Current Reading: " + currReading);
        System.out.println("Units Consumed: " + getUnits());
        System.out.println("Total Bill Amount: Rs. " + calculateBill());
    }
}

public class javaPrg1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Consumer Number: ");
        int cno = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Consumer Name: ");
        String cname = sc.nextLine();

        System.out.print("Enter Previous Month Reading: ");
        int prev = sc.nextInt();

        System.out.print("Enter Current Month Reading: ");
        int curr = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter type of EB connection (domestic/commercial): ");
        String type = sc.nextLine();

        ElectricityBill bill = new ElectricityBill(cno, cname, prev, curr, type);
        bill.displayBill();

        sc.close();
    }
}