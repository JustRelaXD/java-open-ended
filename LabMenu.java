import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class LabLauncher extends JFrame implements ActionListener {

    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9a,b9b,b10;
    JLabel heading;

    LabLauncher() {
        setLayout(null);

        heading = new JLabel("JAVA PROGRAMS");
        heading.setFont(new Font("Arial", Font.BOLD, 32));
        heading.setBounds(820,20,400,40);
        add(heading);

        b1 = new JButton("Generate Electricity Bill");
        b2 = new JButton("Generate Employee Pay Slip");
        b3 = new JButton("Print Area of a Given Shape (Abstract Class)");
        b4 = new JButton("Exception Handling using Try Catch Finally");
        b5 = new JButton("Job Application using User Defined Exception");
        b6 = new JButton("Handling Mouse Based Events");
        b7 = new JButton("Multithreaded Application");
        b8 = new JButton("Producer Consumer Problem");
        b9a = new JButton("String Compare Methods (9A)");
        b9b = new JButton("String Buffer Methods (9B)");
        b10 = new JButton("File Handling Operation");

        b1.setBounds(600,80,700,40);
        b2.setBounds(600,130,700,40);
        b3.setBounds(600,180,700,40);
        b4.setBounds(600,230,700,40);
        b5.setBounds(600,280,700,40);
        b6.setBounds(600,330,700,40);
        b7.setBounds(600,380,700,40);
        b8.setBounds(600,430,700,40);
        b9a.setBounds(600,480,700,40);
        b9b.setBounds(600,530,700,40);
        b10.setBounds(600,580,700,40);

        add(b1); add(b2); add(b3); add(b4); add(b5);
        add(b6); add(b7); add(b8); add(b9a); add(b9b); add(b10);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9a.addActionListener(this);
        b9b.addActionListener(this);
        b10.addActionListener(this);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==b1) GenerateElectricityBill.main(null);
        else if(e.getSource()==b2) GenerateEmployeePaySlip.main(null);
        else if(e.getSource()==b3) PrintAreaOfAGivenShapeUsingAbstractClass.main(null);
        else if(e.getSource()==b4) ExceptionHandlingDemo.main(null);
        else if(e.getSource()==b5) JobApplication.main(null);
        else if(e.getSource()==b6) MouseEventsDemo.main(null);
        else if(e.getSource()==b7) MultithreadedApplication.main(null);
        else if(e.getSource()==b8) ProducerConsumerProblem.main(null);
        else if(e.getSource()==b9a) StringCompareMethods.main(null);
        else if(e.getSource()==b9b) StringBufferMethods.main(null);
        else if(e.getSource()==b10) FileHandlingOperation.main(null);
    }

    public static void main(String[] args) {
        new LabLauncher();
    }
}

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
                amount = 100 + (units - 100) * 2.5;
            else if (units <= 500)
                amount = 100 + 250 + (units - 200) * 4;
            else
                amount = 100 + 250 + 1200 + (units - 500) * 6;
        } else {
            if (units <= 100)
                amount = units * 2;
            else if (units <= 200)
                amount = 200 + (units - 100) * 4.5;
            else if (units <= 500)
                amount = 200 + 450 + (units - 200) * 6;
            else
                amount = 200 + 450 + 1800 + (units - 500) * 7;
        }
        return amount;
    }

    String getBillDetails() {
        return "Consumer No: " + consumerNo +
               "\nConsumer Name: " + consumerName +
               "\nConnection Type: " + type +
               "\nPrevious Reading: " + prevReading +
               "\nCurrent Reading: " + currReading +
               "\nUnits Consumed: " + getUnits() +
               "\nTotal Bill Amount: Rs. " + calculateBill();
    }
}

class GenerateElectricityBill {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Electricity Bill Generator");
        frame.setSize(500, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel lblNo = new JLabel("Consumer No");
        lblNo.setBounds(30,30,150,25);
        frame.add(lblNo);

        JTextField txtNo = new JTextField();
        txtNo.setBounds(200,30,240,25);
        frame.add(txtNo);

        JLabel lblName = new JLabel("Consumer Name");
        lblName.setBounds(30,70,150,25);
        frame.add(lblName);

        JTextField txtName = new JTextField();
        txtName.setBounds(200,70,240,25);
        frame.add(txtName);

        JLabel lblPrev = new JLabel("Previous Reading");
        lblPrev.setBounds(30,110,150,25);
        frame.add(lblPrev);

        JTextField txtPrev = new JTextField();
        txtPrev.setBounds(200,110,240,25);
        frame.add(txtPrev);

        JLabel lblCurr = new JLabel("Current Reading");
        lblCurr.setBounds(30,150,150,25);
        frame.add(lblCurr);

        JTextField txtCurr = new JTextField();
        txtCurr.setBounds(200,150,240,25);
        frame.add(txtCurr);

        JRadioButton rbDomestic = new JRadioButton("Domestic");
        rbDomestic.setBounds(200,190,100,25);
        frame.add(rbDomestic);

        JRadioButton rbCommercial = new JRadioButton("Commercial");
        rbCommercial.setBounds(310,190,130,25);
        frame.add(rbCommercial);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbDomestic);
        bg.add(rbCommercial);

        JButton btnGenerate = new JButton("Generate Bill");
        btnGenerate.setBounds(170,230,160,30);
        frame.add(btnGenerate);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(30,280,440,260);
        textArea.setEditable(false);
        frame.add(textArea);

        btnGenerate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int consumerNo = Integer.parseInt(txtNo.getText());
                String consumerName = txtName.getText();
                int prevReading = Integer.parseInt(txtPrev.getText());
                int currReading = Integer.parseInt(txtCurr.getText());

                if (currReading < prevReading) {
                    textArea.setText("Error: Current reading cannot be less than previous reading");
                    return;
                }

                String type = rbDomestic.isSelected() ? "domestic" : "commercial";

                ElectricityBill bill =
                        new ElectricityBill(consumerNo, consumerName, prevReading, currReading, type);

                textArea.setText(bill.getBillDetails());
            }
        });

        frame.setVisible(true);
    }
}

class Employee {
    String name, id, address, mailId;
    long phone;
    double basicPay;

    Employee(String name, String id, String address, String mailId, long phone, double basicPay) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.mailId = mailId;
        this.phone = phone;
        this.basicPay = basicPay;
    }

    String displayDetails() {
        return "Employee Name: " + name +
               "\nEmployee ID: " + id +
               "\nAddress: " + address +
               "\nMail ID: " + mailId +
               "\nPhone Number: " + phone;
    }
}

class Professor extends Employee {
    Professor(String name, String id, String address, String mailId, long phone, double basicPay) {
        super(name, id, address, mailId, phone, basicPay);
    }

    String generatePaySlip() {
        double da = basicPay * 0.97;
        double hra = basicPay * 0.10;
        double pf = basicPay * 0.12;
        double sfc = basicPay * 0.01;
        double netSalary = (basicPay + da + hra) - (pf + sfc);

        return "Professor Pay Slip\n\n" +
                displayDetails() +
                "\nBasic Pay: " + basicPay +
                "\nDA: " + da +
                "\nHRA: " + hra +
                "\nPF: " + pf +
                "\nStaff Club Fund: " + sfc +
                "\nNet Salary: " + netSalary;
    }
}

class associateProfessor extends Employee {
    associateProfessor(String name, String id, String address, String mailId, long phone, double basicPay) {
        super(name, id, address, mailId, phone, basicPay);
    }

    String generatePaySlip() {
        double da = basicPay * 0.80;
        double hra = basicPay * 0.10;
        double pf = basicPay * 0.12;
        double sfc = basicPay * 0.01;
        double netSalary = (basicPay + da + hra) - (pf + sfc);

        return "Associate Professor Pay Slip\n\n" +
                displayDetails() +
                "\nBasic Pay: " + basicPay +
                "\nDA: " + da +
                "\nHRA: " + hra +
                "\nPF: " + pf +
                "\nStaff Club Fund: " + sfc +
                "\nNet Salary: " + netSalary;
    }
}

class assistantProfessor extends Employee {
    assistantProfessor(String name, String id, String address, String mailId, long phone, double basicPay) {
        super(name, id, address, mailId, phone, basicPay);
    }

    String generatePaySlip() {
        double da = basicPay * 0.60;
        double hra = basicPay * 0.10;
        double pf = basicPay * 0.12;
        double sfc = basicPay * 0.01;
        double netSalary = (basicPay + da + hra) - (pf + sfc);

        return "Assistant Professor Pay Slip\n\n" +
                displayDetails() +
                "\nBasic Pay: " + basicPay +
                "\nDA: " + da +
                "\nHRA: " + hra +
                "\nPF: " + pf +
                "\nStaff Club Fund: " + sfc +
                "\nNet Salary: " + netSalary;
    }
}

class GenerateEmployeePaySlip {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Employee Pay Slip");
        frame.setSize(500, 700);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30, 30, 120, 25);
        frame.add(lblName);

        JTextField txtName = new JTextField();
        txtName.setBounds(180, 30, 260, 25);
        frame.add(txtName);

        JLabel lblId = new JLabel("ID");
        lblId.setBounds(30, 70, 120, 25);
        frame.add(lblId);

        JTextField txtId = new JTextField();
        txtId.setBounds(180, 70, 260, 25);
        frame.add(txtId);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(30, 110, 120, 25);
        frame.add(lblAddress);

        JTextField txtAddress = new JTextField();
        txtAddress.setBounds(180, 110, 260, 25);
        frame.add(txtAddress);

        JLabel lblMail = new JLabel("Mail ID");
        lblMail.setBounds(30, 150, 120, 25);
        frame.add(lblMail);

        JTextField txtMail = new JTextField();
        txtMail.setBounds(180, 150, 260, 25);
        frame.add(txtMail);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(30, 190, 120, 25);
        frame.add(lblPhone);

        JTextField txtPhone = new JTextField();
        txtPhone.setBounds(180, 190, 260, 25);
        frame.add(txtPhone);

        JLabel lblBasicPay = new JLabel("Basic Pay");
        lblBasicPay.setBounds(30, 230, 120, 25);
        frame.add(lblBasicPay);

        JTextField txtBasicPay = new JTextField();
        txtBasicPay.setBounds(180, 230, 260, 25);
        frame.add(txtBasicPay);

        JRadioButton rbProfessor = new JRadioButton("Professor");
        rbProfessor.setBounds(180, 270, 120, 25);
        frame.add(rbProfessor);

        JRadioButton rbAssociate = new JRadioButton("Associate Professor");
        rbAssociate.setBounds(180, 300, 180, 25);
        frame.add(rbAssociate);

        JRadioButton rbAssistant = new JRadioButton("Assistant Professor");
        rbAssistant.setBounds(180, 330, 180, 25);
        frame.add(rbAssistant);

        ButtonGroup group = new ButtonGroup();
        group.add(rbProfessor);
        group.add(rbAssociate);
        group.add(rbAssistant);

        JButton btnGenerate = new JButton("Generate Pay Slip");
        btnGenerate.setBounds(160, 370, 200, 30);
        frame.add(btnGenerate);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(30, 420, 440, 220);
        textArea.setEditable(false);
        frame.add(textArea);

        btnGenerate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name = txtName.getText();
                String id = txtId.getText();
                String address = txtAddress.getText();
                String mailId = txtMail.getText();
                long phone = Long.parseLong(txtPhone.getText());
                double basicPay = Double.parseDouble(txtBasicPay.getText());

                String result;

                if (rbProfessor.isSelected())
                    result = new Professor(name, id, address, mailId, phone, basicPay).generatePaySlip();
                else if (rbAssociate.isSelected())
                    result = new associateProfessor(name, id, address, mailId, phone, basicPay).generatePaySlip();
                else if (rbAssistant.isSelected())
                    result = new assistantProfessor(name, id, address, mailId, phone, basicPay).generatePaySlip();
                else
                    result = "Select Employee Type";

                textArea.setText(result);
            }
        });

        frame.setVisible(true);
    }
}

abstract class Shape {
    abstract double calculateArea();
}

class Rectangle extends Shape {
    int length, breadth;

    Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    double calculateArea() {
        return length * breadth;
    }
}

class Triangle extends Shape {
    int base, height;

    Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }
}

class Circle extends Shape {
    int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    double calculateArea() {
        return 3.14 * radius * radius;
    }
}

class PrintAreaOfAGivenShapeUsingAbstractClass {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Lab 3 - Shape Area Calculator");
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton btnRectangle = new JButton("Rectangle Area");
        btnRectangle.setBounds(150, 30, 200, 30);
        frame.add(btnRectangle);

        JButton btnTriangle = new JButton("Triangle Area");
        btnTriangle.setBounds(150, 70, 200, 30);
        frame.add(btnTriangle);

        JButton btnCircle = new JButton("Circle Area");
        btnCircle.setBounds(150, 110, 200, 30);
        frame.add(btnCircle);

        JTextArea outputArea = new JTextArea();
        outputArea.setBounds(50, 160, 380, 260);
        outputArea.setEditable(false);
        frame.add(outputArea);

        btnRectangle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int length = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Length"));
                int breadth = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Breadth"));

                Shape rect = new Rectangle(length, breadth);
                outputArea.append("Rectangle Area = " + rect.calculateArea() + "\n");
            }
        });

        btnTriangle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int base = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Base"));
                int height = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Height"));

                Shape tri = new Triangle(base, height);
                outputArea.append("Triangle Area = " + tri.calculateArea() + "\n");
            }
        });

        btnCircle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int radius = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter Radius"));

                Shape cir = new Circle(radius);
                outputArea.append("Circle Area = " + cir.calculateArea() + "\n");
            }
        });

        frame.setVisible(true);
    }
}

class ExceptionHandlingDemo {

    static JTextArea outputArea;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Lab 4 - Exception Handling Demo");
        frame.setSize(600, 500);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblChoose = new JLabel("Choose Operation");
        lblChoose.setBounds(220, 10, 200, 25);
        frame.add(lblChoose);

        JButton btnNoEx = new JButton("Run: No Exception");
        btnNoEx.setBounds(200, 50, 200, 30);
        frame.add(btnNoEx);

        JButton btnWithEx = new JButton("Run: With Exception");
        btnWithEx.setBounds(200, 90, 200, 30);
        frame.add(btnWithEx);

        JButton btnWithReturn = new JButton("Run: With Return");
        btnWithReturn.setBounds(200, 130, 200, 30);
        frame.add(btnWithReturn);

        outputArea = new JTextArea();
        outputArea.setBounds(40, 180, 500, 260);
        outputArea.setEditable(false);
        frame.add(outputArea);

        btnNoEx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                noException();
            }
        });

        btnWithEx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                withException();
            }
        });

        btnWithReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                withReturn();
            }
        });

        frame.setVisible(true);
    }

    static void noException() {
        outputArea.append("\n--- No Exception ---\n");
        try {
            outputArea.append("try of noEx\n");
            int x = 10 / 2;
        } catch (Exception e) {
            outputArea.append("catch of noEx\n");
        } finally {
            outputArea.append("finally of noEx\n");
        }
        outputArea.append("end of noEx\n");
    }

    static void withException() {
        outputArea.append("\n--- With Exception ---\n");
        try {
            outputArea.append("try of withEx\n");
            int x = 10 / 0;
        } catch (Exception e) {
            outputArea.append("catch of withEx\n");
        } finally {
            outputArea.append("finally of withEx\n");
        }
        outputArea.append("end of withEx\n");
    }

    static void withReturn() {
        outputArea.append("\n--- With Return ---\n");
        try {
            outputArea.append("try of withReturn\n");
            return;
        } catch (Exception e) {
            outputArea.append("catch of withReturn\n");
        } finally {
            outputArea.append("finally of withReturn\n");
        }
    }
}

class TooEarlyToApply extends Exception {
    TooEarlyToApply() {
        super("Too early to apply (must be at least 18)");
    }
}

class TooLateToApply extends Exception {
    TooLateToApply() {
        super("Too late to apply (must be less than 40)");
    }
}

class JobApplication {

    static JTextField txtName, txtRole, txtAge;
    static JTextArea outputArea;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Lab 5 - Job Application");
        frame.setSize(500, 450);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblTitle = new JLabel("Job Application Form");
        lblTitle.setBounds(170, 10, 200, 25);
        frame.add(lblTitle);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(50, 50, 100, 25);
        frame.add(lblName);

        txtName = new JTextField();
        txtName.setBounds(180, 50, 220, 25);
        frame.add(txtName);

        JLabel lblRole = new JLabel("Role:");
        lblRole.setBounds(50, 90, 100, 25);
        frame.add(lblRole);

        txtRole = new JTextField();
        txtRole.setBounds(180, 90, 220, 25);
        frame.add(txtRole);

        JLabel lblAge = new JLabel("Age:");
        lblAge.setBounds(50, 130, 100, 25);
        frame.add(lblAge);

        txtAge = new JTextField();
        txtAge.setBounds(180, 130, 220, 25);
        frame.add(txtAge);

        JButton btnSubmit = new JButton("Submit Application");
        btnSubmit.setBounds(100, 170, 160, 30);
        frame.add(btnSubmit);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(280, 170, 120, 30);
        frame.add(btnClear);

        outputArea = new JTextArea();
        outputArea.setBounds(50, 220, 380, 170);
        outputArea.setEditable(false);
        frame.add(outputArea);

        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkApplication();
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtName.setText("");
                txtRole.setText("");
                txtAge.setText("");
                outputArea.setText("");
            }
        });

        frame.setVisible(true);
    }

    static void checkApplication() {
        try {
            String name = txtName.getText();
            String role = txtRole.getText();
            int age = Integer.parseInt(txtAge.getText());

            if (age < 18)
                throw new TooEarlyToApply();
            else if (age > 40)
                throw new TooLateToApply();
            else {
                outputArea.setText("APPLICATION ACCEPTED\n\n");
                outputArea.append("Name: " + name + "\n");
                outputArea.append("Role: " + role + "\n");
                outputArea.append("Age: " + age + "\n");
            }

        } catch (NumberFormatException e) {
            outputArea.setText("Error: Invalid age input");
        } catch (Exception e) {
            outputArea.setText("Error: " + e.getMessage());
        }
    }
}

class MouseEventsDemo extends JFrame implements MouseListener {
    private JLabel lblMessage;
    
    public MouseEventsDemo() {
        setTitle("Lab 6 - Mouse Events Demo");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        
        lblMessage = new JLabel("Perform mouse actions in this window");
        lblMessage.setBounds(20, 30, 560, 40);
        lblMessage.setFont(new Font("Arial", Font.BOLD, 16));
        lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblMessage);
        
        addMouseListener(this);
        setVisible(true);
    }
    
    public void mouseExited(MouseEvent e) {
        lblMessage.setText("Mouse exited - X: " + e.getX() + " Y: " + e.getY());
    }
    
    public void mouseEntered(MouseEvent e) {
        lblMessage.setText("Mouse entered - X: " + e.getX() + " Y: " + e.getY());
    }
    
    public void mouseReleased(MouseEvent e) {
        lblMessage.setText("Mouse released - X: " + e.getX() + " Y: " + e.getY());
    }
    
    public void mousePressed(MouseEvent e) {
        lblMessage.setText("Mouse pressed - X: " + e.getX() + " Y: " + e.getY());
    }
    
    public void mouseClicked(MouseEvent e) {
        lblMessage.setText("Mouse clicked - X: " + e.getX() + " Y: " + e.getY());
    }

    public static void main(String[] args) {
        new MouseEventsDemo();
    }
}

class MultithreadedApplication {

    static JTextArea outputArea;
    static JButton btnStart, btnStop;
    static volatile boolean running = false;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Lab 7 - Multithreading Demo");
        frame.setSize(500, 800);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        btnStart = new JButton("Start Demo");
        btnStart.setBounds(120, 30, 120, 30);
        frame.add(btnStart);

        btnStop = new JButton("Stop Demo");
        btnStop.setBounds(260, 30, 120, 30);
        btnStop.setEnabled(false);
        frame.add(btnStop);

        outputArea = new JTextArea();
        outputArea.setBounds(30, 80, 440, 600);
        outputArea.setEditable(false);
        frame.add(outputArea);

        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startDemo();
            }
        });

        btnStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopDemo();
            }
        });

        frame.setVisible(true);
    }

    static void startDemo() {
        running = true;
        btnStart.setEnabled(false);
        btnStop.setEnabled(true);
        outputArea.setText("");

        new Thread(new Runnable() {
            public void run() {
                Random rand = new Random();

                for (int i = 0; i < 10 && running; i++) {
                    int n = rand.nextInt(10);

                    SwingUtilities.invokeLater(() ->
                        outputArea.append("Random: " + n + "\n")
                    );

                    if (n % 2 == 0) {
                        SwingUtilities.invokeLater(() ->
                            outputArea.append("Square of " + n + ": " + (n * n) + "\n\n")
                        );
                    } else {
                        SwingUtilities.invokeLater(() ->
                            outputArea.append("Cube of " + n + ": " + (n * n * n) + "\n\n")
                        );
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        break;
                    }
                }

                SwingUtilities.invokeLater(() -> {
                    btnStart.setEnabled(true);
                    btnStop.setEnabled(false);
                });
            }
        }).start();
    }

    static void stopDemo() {
        running = false;
        btnStart.setEnabled(true);
        btnStop.setEnabled(false);
    }
}

class ProducerConsumerProblem {

    static JTextArea outputArea;
    static JButton btnStart, btnStop;
    static volatile boolean running = false;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Lab 8 - Producer Consumer Demo");
        frame.setSize(500, 900);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        btnStart = new JButton("Start Demo");
        btnStart.setBounds(120, 30, 120, 30);
        frame.add(btnStart);

        btnStop = new JButton("Stop Demo");
        btnStop.setBounds(260, 30, 120, 30);
        btnStop.setEnabled(false);
        frame.add(btnStop);

        outputArea = new JTextArea();
        outputArea.setBounds(30, 80, 440, 700);
        outputArea.setEditable(false);
        frame.add(outputArea);

        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startDemo();
            }
        });

        btnStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopDemo();
            }
        });

        frame.setVisible(true);
    }

    static void startDemo() {
        running = true;
        btnStart.setEnabled(false);
        btnStop.setEnabled(true);
        outputArea.setText("");

        QueueDemo q = new QueueDemo();

        Thread producer = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (running && i < 20) {
                    q.put(i++);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 20 && running; i++) {
                    q.get();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
                SwingUtilities.invokeLater(() -> {
                    btnStart.setEnabled(true);
                    btnStop.setEnabled(false);
                });
            }
        });

        producer.start();
        consumer.start();
    }

    static void stopDemo() {
        running = false;
        btnStart.setEnabled(true);
        btnStop.setEnabled(false);
    }

    static class QueueDemo {
        int n;
        boolean flag = false;

        synchronized void put(int n) {
            while (flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    return;
                }
            }
            this.n = n;
            SwingUtilities.invokeLater(() ->
                outputArea.append("PUT : " + n + "\n")
            );
            flag = true;
            notify();
        }

        synchronized int get() {
            while (!flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    return -1;
                }
            }
            SwingUtilities.invokeLater(() ->
                outputArea.append("GET : " + n + "\n")
            );
            flag = false;
            notify();
            return n;
        }
    }
}

class StringCompareMethods {

    static JTextField txtString1, txtString2;
    static JTextArea outputArea;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Lab 9A - String Comparison Methods");
        frame.setSize(600, 500);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblS1 = new JLabel("String 1:");
        lblS1.setBounds(50, 30, 100, 25);
        frame.add(lblS1);

        txtString1 = new JTextField();
        txtString1.setBounds(150, 30, 380, 25);
        frame.add(txtString1);

        JLabel lblS2 = new JLabel("String 2:");
        lblS2.setBounds(50, 70, 100, 25);
        frame.add(lblS2);

        txtString2 = new JTextField();
        txtString2.setBounds(150, 70, 380, 25);
        frame.add(txtString2);

        JButton btnEquals = new JButton("Equals");
        btnEquals.setBounds(50, 120, 160, 30);
        frame.add(btnEquals);

        JButton btnEqualsIC = new JButton("Equals Ignore Case");
        btnEqualsIC.setBounds(220, 120, 160, 30);
        frame.add(btnEqualsIC);

        JButton btnStarts = new JButton("Starts With");
        btnStarts.setBounds(390, 120, 140, 30);
        frame.add(btnStarts);

        JButton btnEnds = new JButton("Ends With");
        btnEnds.setBounds(50, 160, 160, 30);
        frame.add(btnEnds);

        JButton btnCompare = new JButton("Compare To");
        btnCompare.setBounds(220, 160, 160, 30);
        frame.add(btnCompare);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(390, 160, 140, 30);
        frame.add(btnClear);

        outputArea = new JTextArea();
        outputArea.setBounds(50, 210, 480, 230);
        outputArea.setEditable(false);
        frame.add(outputArea);

        btnEquals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.append(
                    txtString1.getText().equals(txtString2.getText()) ?
                    "Equals: Strings are equal (Case Sensitive)\n" :
                    "Equals: Strings are not equal (Case Sensitive)\n"
                );
            }
        });

        btnEqualsIC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.append(
                    txtString1.getText().equalsIgnoreCase(txtString2.getText()) ?
                    "Equals Ignore Case: Strings are equal\n" :
                    "Equals Ignore Case: Strings are not equal\n"
                );
            }
        });

        btnStarts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.append(
                    txtString1.getText().startsWith(txtString2.getText()) ?
                    "Starts With: String 1 starts with String 2\n" :
                    "Starts With: String 1 does not start with String 2\n"
                );
            }
        });

        btnEnds.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.append(
                    txtString1.getText().endsWith(txtString2.getText()) ?
                    "Ends With: String 1 ends with String 2\n" :
                    "Ends With: String 1 does not end with String 2\n"
                );
            }
        });

        btnCompare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int comp = txtString1.getText().compareTo(txtString2.getText());
                if (comp == 0)
                    outputArea.append("Compare To: Strings are equal\n");
                else if (comp > 0)
                    outputArea.append("Compare To: String 1 is greater than  String 2\n");
                else
                    outputArea.append("Compare To: String 2 is greater than  String 1\n");
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtString1.setText("");
                txtString2.setText("");
                outputArea.setText("");
            }
        });

        frame.setVisible(true);
    }
}

class StringBufferMethods {

    static JTextField txtInput;
    static JTextArea outputArea;
    static StringBuffer sb;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Lab 9B - StringBuffer Operations");
        frame.setSize(600, 500);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblInit = new JLabel("Initial String:");
        lblInit.setBounds(40, 20, 120, 25);
        frame.add(lblInit);

        txtInput = new JTextField();
        txtInput.setBounds(160, 20, 280, 25);
        frame.add(txtInput);

        JButton btnInit = new JButton("Initialize");
        btnInit.setBounds(450, 20, 100, 25);
        frame.add(btnInit);

        JButton btnInsert = new JButton("Insert");
        btnInsert.setBounds(40, 70, 160, 30);
        frame.add(btnInsert);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(220, 70, 160, 30);
        frame.add(btnDelete);

        JButton btnAppend = new JButton("Append");
        btnAppend.setBounds(400, 70, 160, 30);
        frame.add(btnAppend);

        JButton btnReverse = new JButton("Reverse");
        btnReverse.setBounds(40, 110, 160, 30);
        frame.add(btnReverse);

        JButton btnCapacity = new JButton("Capacity");
        btnCapacity.setBounds(220, 110, 160, 30);
        frame.add(btnCapacity);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(400, 110, 160, 30);
        frame.add(btnClear);

        outputArea = new JTextArea();
        outputArea.setBounds(40, 160, 520, 280);
        outputArea.setEditable(false);
        frame.add(outputArea);

        sb = null;

        btnInit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sb = new StringBuffer(txtInput.getText());
                outputArea.setText("StringBuffer initialized: " + sb + "\n");
            }
        });

        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sb == null) {
                    JOptionPane.showMessageDialog(frame, "Initialize StringBuffer first");
                    return;
                }

                try {
                    String posStr = JOptionPane.showInputDialog(
                        frame, "Enter position (0 to " + sb.length() + "):"
                    );
                    if (posStr == null) return;

                    int pos = Integer.parseInt(posStr);

                    if (pos < 0 || pos > sb.length()) {
                        JOptionPane.showMessageDialog(frame, "Invalid position");
                        return;
                    }

                    String str = JOptionPane.showInputDialog(frame, "Enter string to insert:");
                    if (str == null) return;

                    sb.insert(pos, str);
                    outputArea.append("After Insert: " + sb + "\n");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input");
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sb == null) {
                    JOptionPane.showMessageDialog(frame, "Initialize StringBuffer first");
                    return;
                }

                try {
                    int start = Integer.parseInt(
                        JOptionPane.showInputDialog(frame, "Enter start index:")
                    );
                    int end = Integer.parseInt(
                        JOptionPane.showInputDialog(frame, "Enter end index:")
                    );

                    if (start < 0 || end > sb.length() || start >= end) {
                        JOptionPane.showMessageDialog(frame, "Invalid range");
                        return;
                    }

                    sb.delete(start, end);
                    outputArea.append("After Delete: " + sb + "\n");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input");
                }
            }
        });

        btnAppend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sb == null) {
                    JOptionPane.showMessageDialog(frame, "Initialize StringBuffer first");
                    return;
                }

                String str = JOptionPane.showInputDialog(frame, "Enter string to append:");
                if (str != null) {
                    sb.append(str);
                    outputArea.append("After Append: " + sb + "\n");
                }
            }
        });

        btnReverse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sb == null) {
                    JOptionPane.showMessageDialog(frame, "Initialize StringBuffer first");
                    return;
                }

                sb.reverse();
                outputArea.append("After Reverse: " + sb + "\n");
            }
        });

        btnCapacity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sb == null) {
                    JOptionPane.showMessageDialog(frame, "Initialize StringBuffer first");
                    return;
                }

                outputArea.append("Capacity: " + sb.capacity() + "\n");
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.setText("");
            }
        });

        frame.setVisible(true);
    }
}

class FileHandlingOperation {

    static JTextField txtFileName;
    static JTextArea outputArea;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Lab 10 - File Properties Viewer");
        frame.setSize(600, 450);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblFile = new JLabel("File Path:");
        lblFile.setBounds(30, 30, 100, 25);
        frame.add(lblFile);

        txtFileName = new JTextField();
        txtFileName.setBounds(120, 30, 300, 25);
        frame.add(txtFileName);

        JButton btnBrowse = new JButton("Browse");
        btnBrowse.setBounds(430, 30, 100, 25);
        frame.add(btnBrowse);

        JButton btnCheck = new JButton("Check Properties");
        btnCheck.setBounds(220, 70, 160, 30);
        frame.add(btnCheck);

        outputArea = new JTextArea();
        outputArea.setBounds(30, 120, 520, 260);
        outputArea.setEditable(false);
        frame.add(outputArea);

        btnBrowse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int result = chooser.showOpenDialog(frame);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    txtFileName.setText(file.getAbsolutePath());
                }
            }
        });

        btnCheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkProperties();
            }
        });

        frame.setVisible(true);
    }

    static void checkProperties() {

        String fileName = txtFileName.getText();

        if (fileName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter or browse a file!");
            return;
        }

        File f = new File(fileName);

        outputArea.setText("========== FILE PROPERTIES ==========\n\n");

        if (f.exists()) {
            outputArea.append("1. File exists: YES\n");
            outputArea.append("2. File is readable: " + f.canRead() + "\n");
            outputArea.append("3. File is writable: " + f.canWrite() + "\n");

            if (f.isFile())
                outputArea.append("4. Type of file: Regular File\n");
            else if (f.isDirectory())
                outputArea.append("4. Type of file: Directory\n");
            else
                outputArea.append("4. Type of file: Unknown\n");

            outputArea.append("5. Size of file: " + f.length() + " bytes\n");
        } else {
            outputArea.append("1. File exists: NO\n");
            outputArea.append("Other properties cannot be displayed\n");
        }

        outputArea.append("\n=====================================");
    }
}

