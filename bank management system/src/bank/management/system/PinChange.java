package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{

    JButton change, back;
    JPasswordField pintf, repintf;
    String pin;

    PinChange(String pin){

        this.pin = pin;

        setLayout (null);

        JLabel text = new JLabel("Change Your PIN");
        text.setFont(new Font("Osward", Font.BOLD, 20));
        text.setBounds(35, 20, 400,  30);
        add(text);

        JLabel pintext = new JLabel("Enter New PIN");
        pintext.setFont(new Font("Osward", Font.BOLD, 16));
        pintext.setBounds(35, 80, 150,  20);
        add(pintext);

        JLabel repintext = new JLabel("Confirm New PIN");
        repintext.setFont(new Font("Osward", Font.BOLD, 16));
        repintext.setBounds(35, 110, 150,  20);
        add(repintext);

        pintf = new JPasswordField();
        pintf.setFont (new Font("Raleway", Font.BOLD,20));
        pintf.setBounds(200,80,250,22);
        add(pintf);

        repintf = new JPasswordField();
        repintf.setFont (new Font("Raleway", Font.BOLD,20));
        repintf.setBounds(200,110,250,22);
        add(repintf);

        change = new JButton ("CHANGE");
        change.setBounds (35,200,130,40);
        change.setBackground(Color.black);
        change.setForeground(Color.white);
        change.addActionListener(this);
        add (change);

        back = new JButton ("BACK");
        back.setBounds (300,200,130,40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add (back);

        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize (550,320);
        setVisible (true);
        setLocation (310,100);  
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change){
            try{
                String spin = pintf.getText();
                String rpin = repintf.getText();
                if (!spin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if (spin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter PIN");
                    return;
                }
                if (rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }
                Conn conn = new Conn();
                String query1 = "Update bank  set pin='" + rpin + "' where pin='"+pin+"'" ;
                String query2 = "Update login  set pin='" + rpin + "' where pin='"+pin+"'" ;
                String query3 = "Update signupthree  set pin='" + rpin + "' where pin='"+pin+"'" ;
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");

                setVisible(false);
                new Transaction(rpin).setVisible(true);


            }catch (Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
    }
    public static void main (String[] args){
        new PinChange("").setVisible(true);
    }
}

