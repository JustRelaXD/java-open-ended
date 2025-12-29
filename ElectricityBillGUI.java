import javax.swing.*;

public class ElectricityBillGUI extends JFrame {

    JTextField txtNo, txtName, txtPrev, txtCurr;
    JRadioButton rbDomestic, rbCommercial;
    JTextArea output;

    public ElectricityBillGUI() {
        setTitle("Electricity Bill");
        setSize(600, 550);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel l1 = new JLabel("Consumer Number");
        JLabel l2 = new JLabel("Consumer Name");
        JLabel l3 = new JLabel("Previous Reading");
        JLabel l4 = new JLabel("Current Reading");
        JLabel l5 = new JLabel("Connection Type");

        l1.setBounds(40, 30, 150, 25);
        l2.setBounds(40, 70, 150, 25);
        l3.setBounds(40, 110, 150, 25);
        l4.setBounds(40, 150, 150, 25);
        l5.setBounds(40, 190, 150, 25);

        txtNo = new JTextField();
        txtName = new JTextField();
        txtPrev = new JTextField();
        txtCurr = new JTextField();

        txtNo.setBounds(200, 30, 200, 25);
        txtName.setBounds(200, 70, 200, 25);
        txtPrev.setBounds(200, 110, 200, 25);
        txtCurr.setBounds(200, 150, 200, 25);

        rbDomestic = new JRadioButton("Domestic", true);
        rbCommercial = new JRadioButton("Commercial");

        rbDomestic.setBounds(200, 190, 100, 25);
        rbCommercial.setBounds(310, 190, 120, 25);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbDomestic);
        bg.add(rbCommercial);

        JButton btn = new JButton("Generate Bill");
        btn.setBounds(200, 230, 150, 30);

        output = new JTextArea();
        output.setEditable(false);

        JScrollPane sp = new JScrollPane(output);
        sp.setBounds(40, 280, 500, 200);

        btn.addActionListener(e -> generateBill());

        add(l1); add(l2); add(l3); add(l4); add(l5);
        add(txtNo); add(txtName); add(txtPrev); add(txtCurr);
        add(rbDomestic); add(rbCommercial);
        add(btn);
        add(sp);

        setVisible(true);
    }

    void generateBill() {
        int cno = Integer.parseInt(txtNo.getText());
        String name = txtName.getText();
        int prev = Integer.parseInt(txtPrev.getText());
        int curr = Integer.parseInt(txtCurr.getText());
        int units = curr - prev;

        double amount = 0;
        String type;

        if (rbDomestic.isSelected()) {
            type = "Domestic";
            if (units <= 100)
                amount = units * 1;
            else if (units <= 200)
                amount = 100 + (units - 100) * 2.5;
            else if (units <= 500)
                amount = 100 + 250 + (units - 200) * 4;
            else
                amount = 100 + 250 + 1200 + (units - 500) * 6;
        } else {
            type = "Commercial";
            if (units <= 100)
                amount = units * 2;
            else if (units <= 200)
                amount = 200 + (units - 100) * 4.5;
            else if (units <= 500)
                amount = 200 + 450 + (units - 200) * 6;
            else
                amount = 200 + 450 + 1800 + (units - 500) * 7;
        }

        output.setText(
                "Consumer No: " + cno +
                "\nConsumer Name: " + name +
                "\nConnection Type: " + type +
                "\nUnits Consumed: " + units +
                "\nTotal Bill Amount: Rs. " + amount
        );
    }

    public static void main(String[] args) {
        new ElectricityBillGUI();
    }
}
