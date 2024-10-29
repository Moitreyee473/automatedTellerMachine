package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener{

    JButton change, back;
    JPasswordField pintf, repintf;
    String pin;

    BalanceEnquiry(String pin){

        this.pin = pin;

        setLayout (null);

        back = new JButton ("BACK");
        back.setBounds (300,200,130,40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add (back);

        Conn c =new Conn();
        int balance =0;
        try{
            ResultSet rs = c.s.executeQuery("select * from bank where pin='"+pin+"'");    
            while (rs.next()){
                if (rs.getString("type").equals("Deposit")){
                    balance +=  Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -=  Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception  e) {
            System.out.println(e);
        } 
        
        JLabel text = new JLabel("Your current account balance: Rs "+ balance);
        text.setFont(new Font("Osward", Font.BOLD, 20));
        text.setBounds(35, 40, 400,  30);
        add(text);

        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize (550,320);
        setVisible (true);
        setLocation (310,100); 
        
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pin).setVisible(true);
    }

    public static void main (String[] args){
        new BalanceEnquiry("").setVisible(true);
    }
}

