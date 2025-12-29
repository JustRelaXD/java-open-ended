import javax.swing.*;

public class LabLauncher extends JFrame {

    public LabLauncher() {
        setTitle("Java Lab Programs");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu labMenu = new JMenu("Lab Programs");

        JMenuItem lab1 = new JMenuItem("Lab 1");
        JMenuItem lab2 = new JMenuItem("Lab 2");
        JMenuItem lab3 = new JMenuItem("Lab 3");
        JMenuItem lab4 = new JMenuItem("Lab 4");
        JMenuItem lab5 = new JMenuItem("Lab 5");
        JMenuItem lab6 = new JMenuItem("Lab 6");
        JMenuItem lab7 = new JMenuItem("Lab 7");
        JMenuItem lab8 = new JMenuItem("Lab 8");
        JMenuItem lab9 = new JMenuItem("Lab 9");
        JMenuItem lab10 = new JMenuItem("Lab 10");
        
        lab1.addActionListener(e -> new ElectricityBillGUI());
        // lab1.addActionListener(e -> Lab1.main(null));
        // lab2.addActionListener(e -> Lab2.main(null));
        // lab3.addActionListener(e -> Lab3.main(null));
        // lab4.addActionListener(e -> Lab4.main(null));
        // lab5.addActionListener(e -> Lab5.main(null));
        // lab6.addActionListener(e -> Lab6.main(null));
        // lab7.addActionListener(e -> Lab7.main(null));
        // lab8.addActionListener(e -> Lab8.main(null));
        // lab9.addActionListener(e -> Lab9.main(null));
        // lab10.addActionListener(e -> Lab10.main(null));

        labMenu.add(lab1);
        labMenu.add(lab2);
        labMenu.add(lab3);
        labMenu.add(lab4);
        labMenu.add(lab5);
        labMenu.add(lab6);
        labMenu.add(lab7);
        labMenu.add(lab8);
        labMenu.add(lab9);
        labMenu.add(lab10);

        menuBar.add(labMenu);
        setJMenuBar(menuBar);

        setVisible(true);
    }

    public static void main(String[] args) {
        new LabLauncher();
    }
}
