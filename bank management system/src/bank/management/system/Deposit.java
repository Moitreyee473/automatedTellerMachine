package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Date.*;
import java.util.*;
import java.util.Date;




public class Deposit extends JFrame implements ActionListener{

    JButton deposit, back;
    JTextField amount;
    String pin;

    Deposit(String pin){

        this.pin = pin;

        setLayout (null);

        JLabel text = new JLabel("Enter the amount you want to deposit:");
        text.setFont(new Font("Osward", Font.BOLD, 20));
        text.setBounds(35, 20, 400,  30);
        add(text);

        amount = new JTextField();
        amount.setFont (new Font("Raleway", Font.BOLD,14));
        amount.setBounds(35,70,400,30);
        add(amount);

        deposit = new JButton ("DEPOSIT");
        deposit.setBounds (35,150,130,40);
        deposit.setBackground(Color.black);
        deposit.setForeground(Color.white);
        deposit.addActionListener(this);
        add (deposit);

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
        if  (e.getSource() == deposit){
            String number = amount.getText();
            Date b_date= new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount to be deposited:");
            }else{
                try{
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pin+"','"+b_date+"','Deposit','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs. "+number+" Deposited Successfully!");
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
        new Deposit("");
    }
}
