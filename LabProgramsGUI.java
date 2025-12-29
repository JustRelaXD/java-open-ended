import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class LabProgramsGUI extends JFrame {
    
    public LabProgramsGUI() {
        setTitle("Java Lab Programs - Main Menu");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JMenuBar menuBar = new JMenuBar();
        JMenu labMenu = new JMenu("Lab Programs");
        
        String[] programs = {
            "Lab 1 - Electricity Bill",
            "Lab 2 - Employee Pay Slip",
            "Lab 3 - Shape Areas",
            "Lab 4 - Exception Handling Demo",
            "Lab 5 - Custom Exceptions",
            "Lab 6 - Mouse Events",
            "Lab 7 - Random Thread Demo",
            "Lab 8 - Producer Consumer",
            "Lab 9a - String Methods",
            "Lab 9b - StringBuffer Operations",
            "Lab 10 - File Properties"
        };
        
        for (int i = 0; i < programs.length; i++) {
            JMenuItem item = new JMenuItem(programs[i]);
            final int index = i + 1;
            item.addActionListener(e -> openLab(index));
            labMenu.add(item);
        }
        
        menuBar.add(labMenu);
        setJMenuBar(menuBar);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Java Lab Programs", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        
        JTextArea infoArea = new JTextArea();
        infoArea.setEditable(false);
        infoArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        infoArea.setText("\n\n\t\tSelect a Lab Program from the Menu\n\n" +
                        "\tAvailable Programs:\n\n" +
                        "\t1. Electricity Bill Calculator\n" +
                        "\t2. Employee Pay Slip Generator\n" +
                        "\t3. Shape Area Calculator\n" +
                        "\t4. Exception Handling Demo\n" +
                        "\t5. Custom Exception Demo\n" +
                        "\t6. Mouse Events Demo\n" +
                        "\t7. Multi-Threading Demo\n" +
                        "\t8. Producer-Consumer Pattern\n" +
                        "\t9a. String Comparison Methods\n" +
                        "\t9b. StringBuffer Operations\n" +
                        "\t10. File Properties Viewer\n");
        mainPanel.add(infoArea, BorderLayout.CENTER);
        
        add(mainPanel);
        setVisible(true);
    }
    
    private void openLab(int labNumber) {
        switch(labNumber) {
            case 1: new Lab1ElectricityBill(); break;
            case 2: new Lab2EmployeePaySlip(); break;
            case 3: new Lab3ShapeAreas(); break;
            case 4: new Lab4ExceptionDemo(); break;
            case 5: new Lab5CustomExceptions(); break;
            case 6: new Lab6MouseEvents(); break;
            case 7: new Lab7ThreadDemo(); break;
            case 8: new Lab8ProducerConsumer(); break;
            case 9: new Lab9aStringMethods(); break;
            case 10: new Lab9bStringBuffer(); break;
            case 11: new Lab10FileProperties(); break;
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LabProgramsGUI());
    }
}

class Lab1ElectricityBill extends JFrame {
    private JTextField txtConsumerNo, txtConsumerName, txtPrevReading, txtCurrReading;
    private JComboBox<String> cmbType;
    private JTextArea outputArea;
    
    public Lab1ElectricityBill() {
        setTitle("Lab 1 - Electricity Bill Calculator");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        inputPanel.add(new JLabel("Consumer Number:"));
        txtConsumerNo = new JTextField();
        inputPanel.add(txtConsumerNo);
        
        inputPanel.add(new JLabel("Consumer Name:"));
        txtConsumerName = new JTextField();
        inputPanel.add(txtConsumerName);
        
        inputPanel.add(new JLabel("Previous Reading:"));
        txtPrevReading = new JTextField();
        inputPanel.add(txtPrevReading);
        
        inputPanel.add(new JLabel("Current Reading:"));
        txtCurrReading = new JTextField();
        inputPanel.add(txtCurrReading);
        
        inputPanel.add(new JLabel("Connection Type:"));
        cmbType = new JComboBox<>(new String[]{"domestic", "commercial"});
        inputPanel.add(cmbType);
        
        JButton btnCalculate = new JButton("Calculate Bill");
        btnCalculate.addActionListener(e -> calculateBill());
        inputPanel.add(btnCalculate);
        
        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(e -> clearFields());
        inputPanel.add(btnClear);
        
        add(inputPanel, BorderLayout.NORTH);
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    private void calculateBill() {
        try {
            int consumerNo = Integer.parseInt(txtConsumerNo.getText());
            String consumerName = txtConsumerName.getText();
            int prevReading = Integer.parseInt(txtPrevReading.getText());
            int currReading = Integer.parseInt(txtCurrReading.getText());
            String type = cmbType.getSelectedItem().toString();
            
            int units = currReading - prevReading;
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
            } else if (type.equals("commercial")) {
                if (units <= 100)
                    amount = units * 2;
                else if (units <= 200)
                    amount = (100 * 2) + (units - 100) * 4.5;
                else if (units <= 500)
                    amount = (100 * 2) + (100 * 4.5) + (units - 200) * 6;
                else
                    amount = (100 * 2) + (100 * 4.5) + (300 * 6) + (units - 500) * 7;
            }
            
            outputArea.setText("\n============ ELECTRICITY BILL ============\n\n");
            outputArea.append("Consumer Number: " + consumerNo + "\n");
            outputArea.append("Consumer Name: " + consumerName + "\n");
            outputArea.append("Type of Connection: " + type + "\n");
            outputArea.append("Previous Reading: " + prevReading + "\n");
            outputArea.append("Current Reading: " + currReading + "\n");
            outputArea.append("Units Consumed: " + units + "\n");
            outputArea.append("Total Bill Amount: Rs. " + String.format("%.2f", amount) + "\n");
            outputArea.append("\n==========================================\n");
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void clearFields() {
        txtConsumerNo.setText("");
        txtConsumerName.setText("");
        txtPrevReading.setText("");
        txtCurrReading.setText("");
        outputArea.setText("");
    }
}

class Lab2EmployeePaySlip extends JFrame {
    private JTextField txtName, txtId, txtAddress, txtMailId, txtPhone, txtBasicPay;
    private JComboBox<String> cmbType;
    private JTextArea outputArea;
    
    public Lab2EmployeePaySlip() {
        setTitle("Lab 2 - Employee Pay Slip Generator");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        JPanel inputPanel = new JPanel(new GridLayout(8, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        inputPanel.add(new JLabel("Name:"));
        txtName = new JTextField();
        inputPanel.add(txtName);
        
        inputPanel.add(new JLabel("Employee ID:"));
        txtId = new JTextField();
        inputPanel.add(txtId);
        
        inputPanel.add(new JLabel("Address:"));
        txtAddress = new JTextField();
        inputPanel.add(txtAddress);
        
        inputPanel.add(new JLabel("Mail ID:"));
        txtMailId = new JTextField();
        inputPanel.add(txtMailId);
        
        inputPanel.add(new JLabel("Phone Number:"));
        txtPhone = new JTextField();
        inputPanel.add(txtPhone);
        
        inputPanel.add(new JLabel("Basic Pay:"));
        txtBasicPay = new JTextField();
        inputPanel.add(txtBasicPay);
        
        inputPanel.add(new JLabel("Employee Type:"));
        cmbType = new JComboBox<>(new String[]{"Professor", "Associate Professor", "Assistant Professor"});
        inputPanel.add(cmbType);
        
        JButton btnGenerate = new JButton("Generate Pay Slip");
        btnGenerate.addActionListener(e -> generatePaySlip());
        inputPanel.add(btnGenerate);
        
        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(e -> clearFields());
        inputPanel.add(btnClear);
        
        add(inputPanel, BorderLayout.NORTH);
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    private void generatePaySlip() {
        try {
            String name = txtName.getText();
            String id = txtId.getText();
            String address = txtAddress.getText();
            String mailId = txtMailId.getText();
            long phone = Long.parseLong(txtPhone.getText());
            double bp = Double.parseDouble(txtBasicPay.getText());
            String type = cmbType.getSelectedItem().toString();
            
            double da = 0, hra = 0, pf = 0, sfc = 0, net = 0;
            
            if (type.equals("Professor")) {
                da = bp * 0.97;
                hra = bp * 0.10;
                pf = bp * 0.12;
                sfc = bp * 0.01;
            } else if (type.equals("Associate Professor")) {
                da = bp * 0.80;
                hra = bp * 0.10;
                pf = bp * 0.12;
                sfc = bp * 0.01;
            } else if (type.equals("Assistant Professor")) {
                da = bp * 0.60;
                hra = bp * 0.10;
                pf = bp * 0.12;
                sfc = bp * 0.01;
            }
            
            net = (da + bp + hra) - (pf + sfc);
            
            outputArea.setText("\n============ " + type.toUpperCase() + " PAY SLIP ============\n\n");
            outputArea.append("Employee Name: " + name + "\n");
            outputArea.append("Employee ID: " + id + "\n");
            outputArea.append("Address: " + address + "\n");
            outputArea.append("Mail ID: " + mailId + "\n");
            outputArea.append("Phone Number: " + phone + "\n");
            outputArea.append("\n----- Salary Breakdown -----\n");
            outputArea.append("Basic Pay: " + String.format("%.2f", bp) + "\n");
            outputArea.append("DA: " + String.format("%.2f", da) + "\n");
            outputArea.append("HRA: " + String.format("%.2f", hra) + "\n");
            outputArea.append("PF: " + String.format("%.2f", pf) + "\n");
            outputArea.append("Staff Club Fund: " + String.format("%.2f", sfc) + "\n");
            outputArea.append("\nNet Salary: Rs. " + String.format("%.2f", net) + "\n");
            outputArea.append("\n==========================================\n");
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void clearFields() {
        txtName.setText("");
        txtId.setText("");
        txtAddress.setText("");
        txtMailId.setText("");
        txtPhone.setText("");
        txtBasicPay.setText("");
        outputArea.setText("");
    }
}

class Lab3ShapeAreas extends JFrame {
    private JTextArea outputArea;
    
    public Lab3ShapeAreas() {
        setTitle("Lab 3 - Shape Area Calculator");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JButton btnRectangle = new JButton("Calculate Rectangle Area");
        btnRectangle.addActionListener(e -> calculateRectangle());
        buttonPanel.add(btnRectangle);
        
        JButton btnTriangle = new JButton("Calculate Triangle Area");
        btnTriangle.addActionListener(e -> calculateTriangle());
        buttonPanel.add(btnTriangle);
        
        JButton btnCircle = new JButton("Calculate Circle Area");
        btnCircle.addActionListener(e -> calculateCircle());
        buttonPanel.add(btnCircle);
        
        add(buttonPanel, BorderLayout.NORTH);
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    private void calculateRectangle() {
        String lengthStr = JOptionPane.showInputDialog(this, "Enter Length:");
        String breadthStr = JOptionPane.showInputDialog(this, "Enter Breadth:");
        
        if (lengthStr != null && breadthStr != null) {
            try {
                int length = Integer.parseInt(lengthStr);
                int breadth = Integer.parseInt(breadthStr);
                int area = length * breadth;
                outputArea.append("\nRectangle Area = " + area + "\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void calculateTriangle() {
        String baseStr = JOptionPane.showInputDialog(this, "Enter Base:");
        String heightStr = JOptionPane.showInputDialog(this, "Enter Height:");
        
        if (baseStr != null && heightStr != null) {
            try {
                int base = Integer.parseInt(baseStr);
                int height = Integer.parseInt(heightStr);
                double area = 0.5 * base * height;
                outputArea.append("\nTriangle Area = " + area + "\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void calculateCircle() {
        String radiusStr = JOptionPane.showInputDialog(this, "Enter Radius:");
        
        if (radiusStr != null) {
            try {
                int radius = Integer.parseInt(radiusStr);
                double area = 3.14 * radius * radius;
                outputArea.append("\nCircle Area = " + area + "\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

class Lab4ExceptionDemo extends JFrame {
    private JTextArea outputArea;
    
    public Lab4ExceptionDemo() {
        setTitle("Lab 4 - Exception Handling Demo");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JButton btn1 = new JButton("Run: No Exception");
        btn1.addActionListener(e -> noException());
        buttonPanel.add(btn1);
        
        JButton btn2 = new JButton("Run: With Exception");
        btn2.addActionListener(e -> withException());
        buttonPanel.add(btn2);
        
        JButton btn3 = new JButton("Run: With Return");
        btn3.addActionListener(e -> withReturn());
        buttonPanel.add(btn3);
        
        add(buttonPanel, BorderLayout.NORTH);
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    private void noException() {
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
    
    private void withException() {
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
    
    private void withReturn() {
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

class Lab5CustomExceptions extends JFrame {
    private JTextField txtName, txtRole, txtAge;
    private JTextArea outputArea;
    
    public Lab5CustomExceptions() {
        setTitle("Lab 5 - Custom Exception Demo");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        inputPanel.add(new JLabel("Name:"));
        txtName = new JTextField();
        inputPanel.add(txtName);
        
        inputPanel.add(new JLabel("Role:"));
        txtRole = new JTextField();
        inputPanel.add(txtRole);
        
        inputPanel.add(new JLabel("Age:"));
        txtAge = new JTextField();
        inputPanel.add(txtAge);
        
        JButton btnSubmit = new JButton("Submit Application");
        btnSubmit.addActionListener(e -> checkApplication());
        inputPanel.add(btnSubmit);
        
        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(e -> {
            txtName.setText("");
            txtRole.setText("");
            txtAge.setText("");
            outputArea.setText("");
        });
        inputPanel.add(btnClear);
        
        add(inputPanel, BorderLayout.NORTH);
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    private void checkApplication() {
        try {
            String name = txtName.getText();
            String role = txtRole.getText();
            int age = Integer.parseInt(txtAge.getText());
            
            if (age < 18) {
                throw new Exception("Too early to apply (must be at least 18)");
            } else if (age > 40) {
                throw new Exception("Too late to apply (must be at most 40)");
            } else {
                outputArea.setText("\n============ APPLICATION ACCEPTED ============\n\n");
                outputArea.append("Name: " + name + "\n");
                outputArea.append("Role: " + role + "\n");
                outputArea.append("Age: " + age + "\n");
                outputArea.append("\n==========================================\n");
            }
        } catch (NumberFormatException ex) {
            outputArea.setText("\nError: Invalid age input!\n");
        } catch (Exception ex) {
            outputArea.setText("\nError: " + ex.getMessage() + "\n");
        }
    }
}

class Lab6MouseEvents extends JFrame implements MouseListener {
    private JLabel lblMessage;
    
    public Lab6MouseEvents() {
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
}

class Lab7ThreadDemo extends JFrame {
    private JTextArea outputArea;
    private JButton btnStart, btnStop;
    private volatile boolean running = false;
    
    public Lab7ThreadDemo() {
        setTitle("Lab 7 - Multi-Threading Demo");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        btnStart = new JButton("Start Demo");
        btnStart.addActionListener(e -> startDemo());
        buttonPanel.add(btnStart);
        
        btnStop = new JButton("Stop Demo");
        btnStop.setEnabled(false);
        btnStop.addActionListener(e -> stopDemo());
        buttonPanel.add(btnStop);
        
        add(buttonPanel, BorderLayout.NORTH);
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    private void startDemo() {
        running = true;
        btnStart.setEnabled(false);
        btnStop.setEnabled(true);
        outputArea.setText("");
        
        new Thread(() -> {
            Random rand = new Random();
            for (int i = 0; i < 10 && running; i++) {
                int n = rand.nextInt(10);
                SwingUtilities.invokeLater(() -> outputArea.append("Random: " + n + "\n"));
                
                if (n % 2 == 0) {
                    SwingUtilities.invokeLater(() -> outputArea.append("Square of " + n + ": " + (n * n) + "\n\n"));
                } else {
                    SwingUtilities.invokeLater(() -> outputArea.append("Cube of " + n + ": " + (n * n * n) + "\n\n"));
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
        }).start();
    }
    
    private void stopDemo() {
        running = false;
        btnStart.setEnabled(true);
        btnStop.setEnabled(false);
    }
}

class Lab8ProducerConsumer extends JFrame {
    private JTextArea outputArea;
    private JButton btnStart, btnStop;
    private volatile boolean running = false;
    
    public Lab8ProducerConsumer() {
        setTitle("Lab 8 - Producer-Consumer Demo");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        btnStart = new JButton("Start Demo");
        btnStart.addActionListener(e -> startDemo());
        buttonPanel.add(btnStart);
        
        btnStop = new JButton("Stop Demo");
        btnStop.setEnabled(false);
        btnStop.addActionListener(e -> stopDemo());
        buttonPanel.add(btnStop);
        
        add(buttonPanel, BorderLayout.NORTH);
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    private void startDemo() {
        running = true;
        btnStart.setEnabled(false);
        btnStop.setEnabled(true);
        outputArea.setText("");
        
        QueueDemo q = new QueueDemo();
        
        Thread producer = new Thread(() -> {
            int i = 0;
            while (running && i < 20) {
                q.put(i++);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        
        Thread consumer = new Thread(() -> {
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
        });
        
        producer.start();
        consumer.start();
    }
    
    private void stopDemo() {
        running = false;
        btnStart.setEnabled(true);
        btnStop.setEnabled(false);
    }
    
    class QueueDemo {
        int n;
        boolean flag = false;
        
        synchronized void put(int n) {
            while (flag == true) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    return;
                }
            }
            this.n = n;
            SwingUtilities.invokeLater(() -> outputArea.append("PUT: " + n + "\n"));
            flag = true;
            notify();
        }
        
        synchronized int get() {
            while (flag == false) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    return -1;
                }
            }
            SwingUtilities.invokeLater(() -> outputArea.append("GET: " + n + "\n"));
            flag = false;
            notify();
            return n;
        }
    }
}

class Lab9aStringMethods extends JFrame {
    private JTextField txtString1, txtString2;
    private JTextArea outputArea;
    
    public Lab9aStringMethods() {
        setTitle("Lab 9a - String Comparison Methods");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        inputPanel.add(new JLabel("String 1:"));
        txtString1 = new JTextField();
        inputPanel.add(txtString1);
        
        inputPanel.add(new JLabel("String 2:"));
        txtString2 = new JTextField();
        inputPanel.add(txtString2);
        
        add(inputPanel, BorderLayout.NORTH);
        
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        
        String[] operations = {"Equals", "Equals (Ignore Case)", "Starts With", 
                               "Ends With", "Compare To", "Clear"};
        
        for (String op : operations) {
            JButton btn = new JButton(op);
            btn.addActionListener(e -> performOperation(op));
            buttonPanel.add(btn);
        }
        
        add(buttonPanel, BorderLayout.CENTER);
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    private void performOperation(String operation) {
        String s1 = txtString1.getText();
        String s2 = txtString2.getText();
        
        if (operation.equals("Clear")) {
            txtString1.setText("");
            txtString2.setText("");
            outputArea.setText("");
            return;
        }
        
        String result = "";
        
        switch (operation) {
            case "Equals":
                result = s1.equals(s2) ? 
                    "Strings are equal (Case Sensitive)" : 
                    "Strings are not equal (Case Sensitive)";
                break;
            case "Equals (Ignore Case)":
                result = s1.equalsIgnoreCase(s2) ? 
                    "Strings are equal (Case Insensitive)" : 
                    "Strings are not equal (Case Insensitive)";
                break;
            case "Starts With":
                result = s1.startsWith(s2) ? 
                    "String 1 starts with String 2" : 
                    "String 1 does not start with String 2";
                break;
            case "Ends With":
                result = s1.endsWith(s2) ? 
                    "String 1 ends with String 2" : 
                    "String 1 does not end with String 2";
                break;
            case "Compare To":
                int comp = s1.compareTo(s2);
                if (comp == 0)
                    result = "Strings are equal";
                else if (comp > 0)
                    result = "String 1 is greater than String 2";
                else
                    result = "String 2 is greater than String 1";
                break;
        }
        
        outputArea.append(operation + ": " + result + "\n");
    }
}

class Lab9bStringBuffer extends JFrame {
    private JTextField txtInput;
    private JTextArea outputArea;
    private StringBuffer sb;
    
    public Lab9bStringBuffer() {
        setTitle("Lab 9b - StringBuffer Operations");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JLabel lblInit = new JLabel("Initial String:");
        topPanel.add(lblInit, BorderLayout.NORTH);
        
        txtInput = new JTextField();
        topPanel.add(txtInput, BorderLayout.CENTER);
        
        JButton btnInit = new JButton("Initialize");
        btnInit.addActionListener(e -> {
            sb = new StringBuffer(txtInput.getText());
            outputArea.setText("StringBuffer initialized: " + sb + "\nCapacity: " + sb.capacity() + "\n\n");
        });
        topPanel.add(btnInit, BorderLayout.EAST);
        
        add(topPanel, BorderLayout.NORTH);
        
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        
        String[] operations = {"Insert", "Delete", "Append", "Reverse", "Capacity", "Clear"};
        
        for (String op : operations) {
            JButton btn = new JButton(op);
            btn.addActionListener(e -> performOperation(op));
            buttonPanel.add(btn);
        }
        
        add(buttonPanel, BorderLayout.CENTER);
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);
        
        sb = new StringBuffer("");
        
        setVisible(true);
    }
    
    private void performOperation(String operation) {
        if (sb == null) {
            JOptionPane.showMessageDialog(this, "Please initialize StringBuffer first!", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        switch (operation) {
            case "Insert":
                String posStr = JOptionPane.showInputDialog(this, "Enter position:");
                String insStr = JOptionPane.showInputDialog(this, "Enter string to insert:");
                if (posStr != null && insStr != null) {
                    try {
                        int pos = Integer.parseInt(posStr);
                        sb.insert(pos, insStr);
                        outputArea.append("After Insert: " + sb + "\n");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
            case "Delete":
                String startStr = JOptionPane.showInputDialog(this, "Enter start index:");
                String endStr = JOptionPane.showInputDialog(this, "Enter end index:");
                if (startStr != null && endStr != null) {
                    try {
                        int start = Integer.parseInt(startStr);
                        int end = Integer.parseInt(endStr);
                        sb.delete(start, end);
                        outputArea.append("After Delete: " + sb + "\n");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
            case "Append":
                String appStr = JOptionPane.showInputDialog(this, "Enter string to append:");
                if (appStr != null) {
                    sb.append(appStr);
                    outputArea.append("After Append: " + sb + "\n");
                }
                break;
            case "Reverse":
                sb.reverse();
                outputArea.append("After Reverse: " + sb + "\n");
                break;
            case "Capacity":
                outputArea.append("Capacity: " + sb.capacity() + "\n");
                break;
            case "Clear":
                outputArea.setText("");
                break;
        }
    }
}

class Lab10FileProperties extends JFrame {
    private JTextField txtFileName;
    private JTextArea outputArea;
    
    public Lab10FileProperties() {
        setTitle("Lab 10 - File Properties Viewer");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        
        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        topPanel.add(new JLabel("File Path:"), BorderLayout.WEST);
        
        txtFileName = new JTextField();
        topPanel.add(txtFileName, BorderLayout.CENTER);
        
        JPanel buttonSubPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        
        JButton btnBrowse = new JButton("Browse");
        btnBrowse.addActionListener(e -> browseFile());
        buttonSubPanel.add(btnBrowse);
        
        JButton btnCheck = new JButton("Check Properties");
        btnCheck.addActionListener(e -> checkProperties());
        buttonSubPanel.add(btnCheck);
        
        topPanel.add(buttonSubPanel, BorderLayout.EAST);
        
        add(topPanel, BorderLayout.NORTH);
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    private void browseFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            txtFileName.setText(file.getAbsolutePath());
        }
    }
    
    private void checkProperties() {
        String fileName = txtFileName.getText();
        if (fileName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter or browse a file!", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        File f = new File(fileName);
        
        outputArea.setText("\n============ FILE PROPERTIES ============\n\n");
        
        if (f.exists()) {
            outputArea.append("1. File exists: YES\n");
            outputArea.append("2. File is readable: " + f.canRead() + "\n");
            outputArea.append("3. File is writable: " + f.canWrite() + "\n");
            
            if (f.isFile())
                outputArea.append("4. Type of file: Regular file\n");
            else if (f.isDirectory())
                outputArea.append("4. Type of file: Directory\n");
            else
                outputArea.append("4. Type of file: Unknown\n");
            
            outputArea.append("5. Size of file: " + f.length() + " bytes\n");
            outputArea.append("6. Absolute path: " + f.getAbsolutePath() + "\n");
        } else {
            outputArea.append("1. File exists: NO\n");
            outputArea.append("Other properties cannot be displayed\n");
        }
        
        outputArea.append("\n==========================================\n");
    }
}