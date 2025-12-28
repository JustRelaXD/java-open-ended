import java.util.Scanner;

class Employee {
    String name, id, address, mailId;
    long phone;
    double bp;

    Employee(String name, String id, String address, String mailId, long phone, double bp) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.mailId = mailId;
        this.phone = phone;
        this.bp = bp;
    }

    void display() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Address: " + address);
        System.out.println("Mail ID: " + mailId);
        System.out.println("Phone Number: " + phone);
    }
}

class Professor extends Employee {

    Professor(String name, String id, String address, String mailId, long phone, double bp) {
        super(name, id, address, mailId, phone, bp);
    }

    void generatePaySlip() {
        double da = bp * 0.97;
        double hra = bp * 0.10;
        double pf = bp * 0.12;
        double sfc = bp * 0.01;
        double net = (da + bp + hra) - (pf + sfc);

        System.out.println("\nProfessor Pay Slip");
        display();
        System.out.println("Basic Pay: " + bp);
        System.out.println("DA: " + da);
        System.out.println("HRA: " + hra);
        System.out.println("PF: " + pf);
        System.out.println("Staff Club Fund: " + sfc);
        System.out.println("Net Salary: " + net);
    }
}

class associateProfessor extends Employee {

    associateProfessor(String name, String id, String address, String mailId, long phone, double bp) {
        super(name, id, address, mailId, phone, bp);
    }

    void generatePaySlip() {
        double da = bp * 0.80;
        double hra = bp * 0.10;
        double pf = bp * 0.12;
        double sfc = bp * 0.01;
        double net = (da + bp + hra) - (pf + sfc);

        System.out.println("\nAssociate Professor Pay Slip");
        display();
        System.out.println("Basic Pay: " + bp);
        System.out.println("DA: " + da);
        System.out.println("HRA: " + hra);
        System.out.println("PF: " + pf);
        System.out.println("Staff Club Fund: " + sfc);
        System.out.println("Net Salary: " + net);
    }
}

class assistantProfessor extends Employee {

    assistantProfessor(String name, String id, String address, String mailId, long phone, double bp) {
        super(name, id, address, mailId, phone, bp);
    }

    void generatePaySlip() {
        double da = bp * 0.60;
        double hra = bp * 0.10;
        double pf = bp * 0.12;
        double sfc = bp * 0.01;
        double net = (da + bp + hra) - (pf + sfc);

        System.out.println("\nAssistant Professor Pay Slip");
        display();
        System.out.println("Basic Pay: " + bp);
        System.out.println("DA: " + da);
        System.out.println("HRA: " + hra);
        System.out.println("PF: " + pf);
        System.out.println("Staff Club Fund: " + sfc);
        System.out.println("Net Salary: " + net);
    }
}

public class empMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter Mail ID: ");
        String mailId = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        long phone = sc.nextLong();

        System.out.print("Enter Basic Pay: ");
        double bp = sc.nextDouble();

        System.out.println("\nSelect Employee Type:");
        System.out.println("1. Professor");
        System.out.println("2. Associate Professor");
        System.out.println("3. Assistant Professor");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                Professor p = new Professor(name, id, address, mailId, phone, bp);
                p.generatePaySlip();
                break;

            case 2:
                associateProfessor ap = new associateProfessor(name, id, address, mailId, phone, bp);
                ap.generatePaySlip();
                break;

            case 3:
                assistantProfessor asp = new assistantProfessor(name, id, address, mailId, phone, bp);
                asp.generatePaySlip();
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}