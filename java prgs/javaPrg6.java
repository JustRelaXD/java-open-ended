import javax.swing.*;
import java.awt.event.*;

class MyFrame extends JFrame implements MouseListener{
    JLabel lblMessage;
    MyFrame(){
        this.setSize(500,500);
        this.setLayout(null);
        lblMessage = new JLabel("Mouse event");
        lblMessage.setBounds(20,30, 500, 40);
        this.add(lblMessage);
        this.addMouseListener(this);
        this.setVisible(true);
    }

    public void mouseExited(MouseEvent e){
        lblMessage.setText("Mouse entered= X: "+e.getX()+" Y: "+e.getY());

    }
    public void mouseEntered(MouseEvent e){
        lblMessage.setText("Mouse exited= X: "+e.getX()+" Y: "+e.getY());
    }
    public void mouseReleased(MouseEvent e){

    }
    public void mousePressed(MouseEvent e){
        lblMessage.setText("Mouse pressed = X: "+e.getX()+" Y: "+e.getY());
    }
    public void mouseClicked(MouseEvent e){
        lblMessage.setText("Mouse clicked = X: "+e.getX()+" Y: "+e.getY());
    }
}

public class javaPrg6 {
    public static void main(String[] args) {
        new MyFrame();
    }
}