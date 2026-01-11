import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class LabMenu extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu programMenu;
    JMenuItem item1, item2, item3, item4, item5, item6, item7, item8, item9a, item9b, item10;

    JPanel contentPanel;
    CardLayout cardLayout;

    LabMenu() {

        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        add(contentPanel, BorderLayout.CENTER);

        JPanel welcomePanel = new JPanel();
        JLabel welcomeLabel = new JLabel("Select a program from the menu above");
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        welcomePanel.add(welcomeLabel);
        contentPanel.add(welcomePanel, "welcome");

        contentPanel.add(GenerateElectricityBill.createPanel(), "prog1");
        contentPanel.add(GenerateEmployeePaySlip.createPanel(), "prog2");
        contentPanel.add(PrintAreaOfAGivenShapeUsingAbstractClass.createPanel(), "prog3");
        contentPanel.add(ExceptionHandlingDemo.createPanel(), "prog4");
        contentPanel.add(JobApplication.createPanel(), "prog5");
        contentPanel.add(MouseEventsDemo.createPanel(), "prog6");
        contentPanel.add(MultithreadedApplication.createPanel(), "prog7");
        contentPanel.add(ProducerConsumerProblem.createPanel(), "prog8");
        contentPanel.add(StringCompareMethods.createPanel(), "prog9a");
        contentPanel.add(StringBufferMethods.createPanel(), "prog9b");
        contentPanel.add(FileHandlingOperation.createPanel(), "prog10");

        menuBar = new JMenuBar();
        programMenu = new JMenu("Select Program");
        programMenu.setFont(new Font("Arial", Font.BOLD, 16));

        item1 = new JMenuItem("Generate Electricity Bill");
        item2 = new JMenuItem("Generate Employee Pay Slip");
        item3 = new JMenuItem("Print Area of a Given Shape (Abstract Class)");
        item4 = new JMenuItem("Exception Handling using Try Catch Finally");
        item5 = new JMenuItem("Job Application using User Defined Exception");
        item6 = new JMenuItem("Handling Mouse Based Events");
        item7 = new JMenuItem("Multithreaded Application");
        item8 = new JMenuItem("Producer Consumer Problem");
        item9a = new JMenuItem("String Compare Methods (9A)");
        item9b = new JMenuItem("String Buffer Methods (9B)");
        item10 = new JMenuItem("File Handling Operation");

        item1.addActionListener(this); programMenu.add(item1);
        item2.addActionListener(this); programMenu.add(item2);
        item3.addActionListener(this); programMenu.add(item3);
        item4.addActionListener(this); programMenu.add(item4);
        item5.addActionListener(this); programMenu.add(item5);
        item6.addActionListener(this); programMenu.add(item6);
        item7.addActionListener(this); programMenu.add(item7);
        item8.addActionListener(this); programMenu.add(item8);
        item9a.addActionListener(this); programMenu.add(item9a);
        item9b.addActionListener(this); programMenu.add(item9b);
        item10.addActionListener(this); programMenu.add(item10);
        
        menuBar.add(programMenu);
        setJMenuBar(menuBar);
        setSize(650, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==item1) cardLayout.show(contentPanel, "prog1");
        else if(e.getSource()==item2) cardLayout.show(contentPanel, "prog2");
        else if(e.getSource()==item3) cardLayout.show(contentPanel, "prog3");
        else if(e.getSource()==item4) cardLayout.show(contentPanel, "prog4");
        else if(e.getSource()==item5) cardLayout.show(contentPanel, "prog5");
        else if(e.getSource()==item6) cardLayout.show(contentPanel, "prog6");
        else if(e.getSource()==item7) cardLayout.show(contentPanel, "prog7");
        else if(e.getSource()==item8) cardLayout.show(contentPanel, "prog8");
        else if(e.getSource()==item9a) cardLayout.show(contentPanel, "prog9a");
        else if(e.getSource()==item9b) cardLayout.show(contentPanel, "prog9b");
        else if(e.getSource()==item10) cardLayout.show(contentPanel, "prog10");
    }

    public static void main(String[] args) {
        new LabMenu();
    }
}

// ELECTRICITY BILL 
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

    public static JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblNo = new JLabel("Consumer No");
        lblNo.setBounds(30,30,150,25);
        panel.add(lblNo);

        JTextField txtNo = new JTextField();
        txtNo.setBounds(200,30,240,25);
        panel.add(txtNo);

        JLabel lblName = new JLabel("Consumer Name");
        lblName.setBounds(30,70,150,25);
        panel.add(lblName);

        JTextField txtName = new JTextField();
        txtName.setBounds(200,70,240,25);
        panel.add(txtName);

        JLabel lblPrev = new JLabel("Previous Reading");
        lblPrev.setBounds(30,110,150,25);
        panel.add(lblPrev);

        JTextField txtPrev = new JTextField();
        txtPrev.setBounds(200,110,240,25);
        panel.add(txtPrev);

        JLabel lblCurr = new JLabel("Current Reading");
        lblCurr.setBounds(30,150,150,25);
        panel.add(lblCurr);

        JTextField txtCurr = new JTextField();
        txtCurr.setBounds(200,150,240,25);
        panel.add(txtCurr);

        JRadioButton rbDomestic = new JRadioButton("Domestic");
        rbDomestic.setBounds(200,190,100,25);
        panel.add(rbDomestic);

        JRadioButton rbCommercial = new JRadioButton("Commercial");
        rbCommercial.setBounds(310,190,130,25);
        panel.add(rbCommercial);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbDomestic);
        bg.add(rbCommercial);

        JButton btnGenerate = new JButton("Generate Bill");
        btnGenerate.setBounds(170,230,160,30);
        panel.add(btnGenerate);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(30,280,440,260);
        textArea.setEditable(false);
        panel.add(textArea);

        btnGenerate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int consumerNo = Integer.parseInt(txtNo.getText());
                    String consumerName = txtName.getText();
                    int prevReading = Integer.parseInt(txtPrev.getText());
                    int currReading = Integer.parseInt(txtCurr.getText());

                    if (currReading < prevReading) {
                        textArea.setText("Error: Current reading cannot be less than previous reading");
                        return;
                    }

                    String type = rbDomestic.isSelected() ? "domestic" : "commercial";

                    ElectricityBill bill = new ElectricityBill(consumerNo, consumerName, prevReading, currReading, type);
                    textArea.setText(bill.getBillDetails());
                } catch (Exception ex) {
                    textArea.setText("Error: Please enter valid data");
                }
            }
        });

        return panel;
    }
}

//  EMPLOYEE PAY SLIP
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

    public static JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30, 30, 120, 25);
        panel.add(lblName);

        JTextField txtName = new JTextField();
        txtName.setBounds(180, 30, 260, 25);
        panel.add(txtName);

        JLabel lblId = new JLabel("ID");
        lblId.setBounds(30, 70, 120, 25);
        panel.add(lblId);

        JTextField txtId = new JTextField();
        txtId.setBounds(180, 70, 260, 25);
        panel.add(txtId);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(30, 110, 120, 25);
        panel.add(lblAddress);

        JTextField txtAddress = new JTextField();
        txtAddress.setBounds(180, 110, 260, 25);
        panel.add(txtAddress);

        JLabel lblMail = new JLabel("Mail ID");
        lblMail.setBounds(30, 150, 120, 25);
        panel.add(lblMail);

        JTextField txtMail = new JTextField();
        txtMail.setBounds(180, 150, 260, 25);
        panel.add(txtMail);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(30, 190, 120, 25);
        panel.add(lblPhone);

        JTextField txtPhone = new JTextField();
        txtPhone.setBounds(180, 190, 260, 25);
        panel.add(txtPhone);

        JLabel lblBasicPay = new JLabel("Basic Pay");
        lblBasicPay.setBounds(30, 230, 120, 25);
        panel.add(lblBasicPay);

        JTextField txtBasicPay = new JTextField();
        txtBasicPay.setBounds(180, 230, 260, 25);
        panel.add(txtBasicPay);

        JRadioButton rbProfessor = new JRadioButton("Professor");
        rbProfessor.setBounds(180, 270, 120, 25);
        panel.add(rbProfessor);

        JRadioButton rbAssociate = new JRadioButton("Associate Professor");
        rbAssociate.setBounds(180, 300, 180, 25);
        panel.add(rbAssociate);

        JRadioButton rbAssistant = new JRadioButton("Assistant Professor");
        rbAssistant.setBounds(180, 330, 180, 25);
        panel.add(rbAssistant);

        ButtonGroup group = new ButtonGroup();
        group.add(rbProfessor);
        group.add(rbAssociate);
        group.add(rbAssistant);

        JButton btnGenerate = new JButton("Generate Pay Slip");
        btnGenerate.setBounds(160, 370, 200, 30);
        panel.add(btnGenerate);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(30, 420, 440, 350);
        textArea.setEditable(false);
        panel.add(textArea);

        btnGenerate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
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
                } catch (Exception ex) {
                    textArea.setText("Error: Please enter valid data");
                }
            }
        });

        return panel;
    }
}

// SHAPE AREA CALCULATOR 
abstract class Shape {
    int dim1, dim2;

    Shape(int dim1, int dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    abstract double calculateArea();
}

class Rectangle extends Shape {

    Rectangle(int length, int breadth) {
        super(length, breadth);
    }

    double calculateArea() {
        return dim1 * dim2;
    }
}

class Triangle extends Shape {

    Triangle(int base, int height) {
        super(base, height);
    }

    double calculateArea() {
        return 0.5 * dim1 * dim2;
    }
}

class Circle extends Shape {

    Circle(int radius) {
        super(radius, 0);
    }

    double calculateArea() {
        return 3.14 * dim1 * dim1;
    }
}

class PrintAreaOfAGivenShapeUsingAbstractClass {

    public static JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton btnRectangle = new JButton("Rectangle Area");
        btnRectangle.setBounds(150, 30, 200, 30);
        panel.add(btnRectangle);

        JButton btnTriangle = new JButton("Triangle Area");
        btnTriangle.setBounds(150, 70, 200, 30);
        panel.add(btnTriangle);

        JButton btnCircle = new JButton("Circle Area");
        btnCircle.setBounds(150, 110, 200, 30);
        panel.add(btnCircle);

        JTextArea outputArea = new JTextArea();
        outputArea.setBounds(50, 160, 380, 260);
        outputArea.setEditable(false);
        panel.add(outputArea);

        btnRectangle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int length = Integer.parseInt(JOptionPane.showInputDialog(panel, "Enter Length"));
                    int breadth = Integer.parseInt(JOptionPane.showInputDialog(panel, "Enter Breadth"));

                    Shape rect = new Rectangle(length, breadth);
                    outputArea.append("Rectangle Area = " + rect.calculateArea() + "\n");
                } catch (Exception ex) {
                    outputArea.append("Error: Invalid input\n");
                }
            }
        });

        btnTriangle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int base = Integer.parseInt(JOptionPane.showInputDialog(panel, "Enter Base"));
                    int height = Integer.parseInt(JOptionPane.showInputDialog(panel, "Enter Height"));

                    Shape tri = new Triangle(base, height);
                    outputArea.append("Triangle Area = " + tri.calculateArea() + "\n");
                } catch (Exception ex) {
                    outputArea.append("Error: Invalid input\n");
                }
            }
        });

        btnCircle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int radius = Integer.parseInt(JOptionPane.showInputDialog(panel, "Enter Radius"));

                    Shape cir = new Circle(radius);
                    outputArea.append("Circle Area = " + cir.calculateArea() + "\n");
                } catch (Exception ex) {
                    outputArea.append("Error: Invalid input\n");
                }
            }
        });

        return panel;
    }
}

// EXCEPTION HANDLING 
class ExceptionHandlingDemo {

    public static JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblChoose = new JLabel("Choose Operation");
        lblChoose.setBounds(220, 10, 200, 25);
        panel.add(lblChoose);

        JButton btnNoEx = new JButton("Run: No Exception");
        btnNoEx.setBounds(200, 50, 200, 30);
        panel.add(btnNoEx);

        JButton btnWithEx = new JButton("Run: With Exception");
        btnWithEx.setBounds(200, 90, 200, 30);
        panel.add(btnWithEx);

        JButton btnWithReturn = new JButton("Run: With Return");
        btnWithReturn.setBounds(200, 130, 200, 30);
        panel.add(btnWithReturn);

        JTextArea outputArea = new JTextArea();
        outputArea.setBounds(40, 180, 500, 600);
        outputArea.setEditable(false);
        panel.add(outputArea);

        btnNoEx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                noException(outputArea);
            }
        });

        btnWithEx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                withException(outputArea);
            }
        });

        btnWithReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                withReturn(outputArea);
            }
        });

        return panel;
    }

    static void noException(JTextArea outputArea) {
        outputArea.append("\n--- No Exception ---\n");
        try {
            outputArea.append("try of No Exception\n");
            int x = 10 / 2;
        } catch (Exception e) {
            outputArea.append("catch of No Exception\n");
        } finally {
            outputArea.append("finally of No Exception\n");
        }
        outputArea.append("end of No Exception\n");
    }

    static void withException(JTextArea outputArea) {
        outputArea.append("\n--- With Exception ---\n");
        try {
            outputArea.append("try of With Exception\n");
            int x = 10 / 0;
        } catch (Exception e) {
            outputArea.append("catch of With Exception\n");
        } finally {
            outputArea.append("finally of With Exception\n");
        }
        outputArea.append("end of With Exception\n");
    }

    static void withReturn(JTextArea outputArea) {
        outputArea.append("\n--- With Return ---\n");
        try {
            outputArea.append("try of With Exception\n");
            return;
        } catch (Exception e) {
            outputArea.append("catch of With Exception\n");
        } finally {
            outputArea.append("finally of With Exception\n");
        }
    }
}

// JOB APPLICATION
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

    public static JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblTitle = new JLabel("Job Application Form");
        lblTitle.setBounds(170, 10, 200, 25);
        panel.add(lblTitle);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(50, 50, 100, 25);
        panel.add(lblName);

        JTextField txtName = new JTextField();
        txtName.setBounds(180, 50, 220, 25);
        panel.add(txtName);

        JLabel lblRole = new JLabel("Role:");
        lblRole.setBounds(50, 90, 100, 25);
        panel.add(lblRole);

        JTextField txtRole = new JTextField();
        txtRole.setBounds(180, 90, 220, 25);
        panel.add(txtRole);

        JLabel lblAge = new JLabel("Age:");
        lblAge.setBounds(50, 130, 100, 25);
        panel.add(lblAge);

        JTextField txtAge = new JTextField();
        txtAge.setBounds(180, 130, 220, 25);
        panel.add(txtAge);

        JButton btnSubmit = new JButton("Submit Application");
        btnSubmit.setBounds(100, 170, 160, 30);
        panel.add(btnSubmit);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(280, 170, 120, 30);
        panel.add(btnClear);

        JTextArea outputArea = new JTextArea();
        outputArea.setBounds(50, 220, 380, 500);
        outputArea.setEditable(false);
        panel.add(outputArea);

        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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

                } catch (NumberFormatException ex) {
                    outputArea.setText("Error: Invalid age input");
                } catch (Exception ex) {
                    outputArea.setText("Error: " + ex.getMessage());
                }
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

        return panel;
    }
}

//  MOUSE EVENTS
class MouseEventsDemo {
    
    public static JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
       
        JLabel lblMessage = new JLabel("Perform mouse actions in this area");
        lblMessage.setBounds(20, 30, 560, 40);
        lblMessage.setFont(new Font("Arial", Font.BOLD, 16));
        lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblMessage);
       
        panel.addMouseListener(new MouseListener() {
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
        });

        return panel;
    }
}

// MULTITHREADING

class MultithreadedApplication {

    public static JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton btnStart = new JButton("Start Demo");
        btnStart.setBounds(120, 30, 120, 30);
        panel.add(btnStart);

        JButton btnStop = new JButton("Stop Demo");
        btnStop.setBounds(260, 30, 120, 30);
        btnStop.setEnabled(false);
        panel.add(btnStop);

        JTextArea outputArea = new JTextArea();
        outputArea.setBounds(30, 80, 440, 600);
        outputArea.setEditable(false);
        panel.add(outputArea);

        final boolean[] running = {false};
        final Thread[] demoThread = {null};

        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                running[0] = true;
                btnStart.setEnabled(false);
                btnStop.setEnabled(true);
                outputArea.setText("");

                demoThread[0] = new Thread(new Runnable() {
                    public void run() {
                        Random rand = new Random();

                        for (int i = 0; i < 10 && running[0]; i++) {
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
                            } catch (InterruptedException ex) {
                                break;
                            }
                        }

                        SwingUtilities.invokeLater(() -> {
                            btnStart.setEnabled(true);
                            btnStop.setEnabled(false);
                        });
                    }
                });
                demoThread[0].start();
            }
        });

        btnStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                running[0] = false;
                btnStart.setEnabled(true);
                btnStop.setEnabled(false);
            }
        });

        return panel;
    }
}

// PRODUCER CONSUMER

class ProducerConsumerProblem {

    public static JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton btnStart = new JButton("Start Demo");
        btnStart.setBounds(120, 30, 120, 30);
        panel.add(btnStart);

        JButton btnStop = new JButton("Stop Demo");
        btnStop.setBounds(260, 30, 120, 30);
        btnStop.setEnabled(false);
        panel.add(btnStop);

        JTextArea outputArea = new JTextArea();
        outputArea.setBounds(30, 80, 440, 700);
        outputArea.setEditable(false);
        panel.add(outputArea);

        final boolean[] running = {false};

        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                running[0] = true;
                btnStart.setEnabled(false);
                btnStop.setEnabled(true);
                outputArea.setText("");

                QueueDemo q = new QueueDemo(outputArea);

                Thread producer = new Thread(new Runnable() {
                    public void run() {
                        int i = 0;
                        while (running[0] && i < 20) {
                            q.put(i++);
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException ex) {
                                break;
                            }
                        }
                    }
                });

                Thread consumer = new Thread(new Runnable() {
                    public void run() {
                        for (int i = 0; i < 20 && running[0]; i++) {
                            q.get();
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException ex) {
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
        });

        btnStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                running[0] = false;
                btnStart.setEnabled(true);
                btnStop.setEnabled(false);
            }
        });

        return panel;
    }

    static class QueueDemo {
        int n;
        boolean flag = false;
        JTextArea outputArea;

        QueueDemo(JTextArea outputArea) {
            this.outputArea = outputArea;
        }

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

// STRING COMPARE 

class StringCompareMethods {

    public static JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblS1 = new JLabel("String 1:");
        lblS1.setBounds(50, 30, 100, 25);
        panel.add(lblS1);

        JTextField txtString1 = new JTextField();
        txtString1.setBounds(150, 30, 380, 25);
        panel.add(txtString1);

        JLabel lblS2 = new JLabel("String 2:");
        lblS2.setBounds(50, 70, 100, 25);
        panel.add(lblS2);

        JTextField txtString2 = new JTextField();
        txtString2.setBounds(150, 70, 380, 25);
        panel.add(txtString2);

        JButton btnEquals = new JButton("Equals");
        btnEquals.setBounds(50, 120, 160, 30);
        panel.add(btnEquals);

        JButton btnEqualsIC = new JButton("Equals Ignore Case");
        btnEqualsIC.setBounds(220, 120, 160, 30);
        panel.add(btnEqualsIC);

        JButton btnStarts = new JButton("Starts With");
        btnStarts.setBounds(390, 120, 140, 30);
        panel.add(btnStarts);

        JButton btnEnds = new JButton("Ends With");
        btnEnds.setBounds(50, 160, 160, 30);
        panel.add(btnEnds);

        JButton btnCompare = new JButton("Compare To");
        btnCompare.setBounds(220, 160, 160, 30);
        panel.add(btnCompare);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(390, 160, 140, 30);
        panel.add(btnClear);

        JTextArea outputArea = new JTextArea();
        outputArea.setBounds(50, 210, 480, 230);
        outputArea.setEditable(false);
        panel.add(outputArea);

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
                    outputArea.append("Compare To: String 1 is greater than String 2\n");
                else
                    outputArea.append("Compare To: String 2 is greater than String 1\n");
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtString1.setText("");
                txtString2.setText("");
                outputArea.setText("");
            }
        });

        return panel;
    }
}

// STRING BUFFER

class StringBufferMethods {

    public static JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblInit = new JLabel("Initial String:");
        lblInit.setBounds(40, 20, 120, 25);
        panel.add(lblInit);

        JTextField txtInput = new JTextField();
        txtInput.setBounds(160, 20, 280, 25);
        panel.add(txtInput);

        JButton btnInit = new JButton("Initialize");
        btnInit.setBounds(450, 20, 100, 25);
        panel.add(btnInit);

        JButton btnInsert = new JButton("Insert");
        btnInsert.setBounds(40, 70, 160, 30);
        panel.add(btnInsert);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(220, 70, 160, 30);
        panel.add(btnDelete);

        JButton btnAppend = new JButton("Append");
        btnAppend.setBounds(400, 70, 160, 30);
        panel.add(btnAppend);

        JButton btnReverse = new JButton("Reverse");
        btnReverse.setBounds(40, 110, 160, 30);
        panel.add(btnReverse);

        JButton btnCapacity = new JButton("Capacity");
        btnCapacity.setBounds(220, 110, 160, 30);
        panel.add(btnCapacity);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(400, 110, 160, 30);
        panel.add(btnClear);

        JTextArea outputArea = new JTextArea();
        outputArea.setBounds(40, 160, 520, 280);
        outputArea.setEditable(false);
        panel.add(outputArea);

        final StringBuffer[] sb = {null};

        btnInit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sb[0] = new StringBuffer(txtInput.getText());
                outputArea.setText("StringBuffer initialized: " + sb[0] + "\n");
            }
        });

        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sb[0] == null) {
                    JOptionPane.showMessageDialog(panel, "Initialize StringBuffer first");
                    return;
                }

                try {
                    String posStr = JOptionPane.showInputDialog(
                        panel, "Enter position (0 to " + sb[0].length() + "):"
                    );
                    if (posStr == null) return;

                    int pos = Integer.parseInt(posStr);

                    if (pos < 0 || pos > sb[0].length()) {
                        JOptionPane.showMessageDialog(panel, "Invalid position");
                        return;
                    }

                    String str = JOptionPane.showInputDialog(panel, "Enter string to insert:");
                    if (str == null) return;

                    sb[0].insert(pos, str);
                    outputArea.append("After Insert: " + sb[0] + "\n");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, "Invalid input");
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sb[0] == null) {
                    JOptionPane.showMessageDialog(panel, "Initialize StringBuffer first");
                    return;
                }

                try {
                    int start = Integer.parseInt(
                        JOptionPane.showInputDialog(panel, "Enter start index:")
                    );
                    int end = Integer.parseInt(
                        JOptionPane.showInputDialog(panel, "Enter end index:")
                    );

                    if (start < 0 || end > sb[0].length() || start >= end) {
                        JOptionPane.showMessageDialog(panel, "Invalid range");
                        return;
                    }

                    sb[0].delete(start, end);
                    outputArea.append("After Delete: " + sb[0] + "\n");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, "Invalid input");
                }
            }
        });

        btnAppend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sb[0] == null) {
                    JOptionPane.showMessageDialog(panel, "Initialize StringBuffer first");
                    return;
                }

                String str = JOptionPane.showInputDialog(panel, "Enter string to append:");
                if (str != null) {
                    sb[0].append(str);
                    outputArea.append("After Append: " + sb[0] + "\n");
                }
            }
        });

        btnReverse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sb[0] == null) {
                    JOptionPane.showMessageDialog(panel, "Initialize StringBuffer first");
                    return;
                }

                sb[0].reverse();
                outputArea.append("After Reverse: " + sb[0] + "\n");
            }
        });

        btnCapacity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sb[0] == null) {
                    JOptionPane.showMessageDialog(panel, "Initialize StringBuffer first");
                    return;
                }

                outputArea.append("Capacity: " + sb[0].capacity() + "\n");
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.setText("");
            }
        });

        return panel;
    }
}

// FILE HANDLING

class FileHandlingOperation {

    public static JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblFile = new JLabel("File Path:");
        lblFile.setBounds(30, 30, 100, 25);
        panel.add(lblFile);

        JTextField txtFileName = new JTextField();
        txtFileName.setBounds(120, 30, 300, 25);
        panel.add(txtFileName);

        JButton btnBrowse = new JButton("Browse");
        btnBrowse.setBounds(430, 30, 100, 25);
        panel.add(btnBrowse);

        JButton btnCheck = new JButton("Check Properties");
        btnCheck.setBounds(220, 70, 160, 30);
        panel.add(btnCheck);

        JTextArea outputArea = new JTextArea();
        outputArea.setBounds(30, 120, 520, 260);
        outputArea.setEditable(false);
        panel.add(outputArea);

        btnBrowse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int result = chooser.showOpenDialog(panel);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    txtFileName.setText(file.getAbsolutePath());
                }
            }
        });

        btnCheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = txtFileName.getText();

                if (fileName.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Please enter or browse a file!");
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
        });

        return panel;
    }
}