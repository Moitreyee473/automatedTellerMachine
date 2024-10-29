package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.sql.*;
import java.util.*;
import java.sql.Date.*;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener{

    JButton withdraw, back;
    JTextField amount;
    String pin;

    Withdrawl(String pin){

        this.pin = pin;

        setLayout (null);

        JLabel text = new JLabel("Enter the amount you want to withdraw:");
        text.setFont(new Font("Osward", Font.BOLD, 20));
        text.setBounds(35, 20, 400,  30);
        add(text);

        amount = new JTextField();
        amount.setFont (new Font("Raleway", Font.BOLD,14));
        amount.setBounds(35,70,400,30);
        add(amount);

        withdraw = new JButton ("WITHDRAW");
        withdraw.setBounds (35,150,130,40);
        withdraw.setBackground(Color.black);
        withdraw.setForeground(Color.white);
        withdraw.addActionListener(this);
        add (withdraw);

        back = new JButton ("BACK");
        back.setBounds (300,150,130,40);
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

    public void actionPerformed(ActionEvent e) {
        if  (e.getSource() == withdraw){
            String number = amount.getText();
            Date  date= new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount to be withdrawn:");
            }else{
                try{
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pin+"','"+date+"','Withdrawl','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs. "+number+" Withdrawn Successfully!");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }catch(Exception ex){
                    System.out.println(ex);
                }
            }
        }else if (e.getSource ()== back){
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
    }

    public static void main (String[] args){
        new Withdrawl("");
    }
}
