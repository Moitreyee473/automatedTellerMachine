package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{

    JButton deposit, withdrawl, fastcash, pinchange, baleq, exit;
    String pin;

    Transaction(String pin){

        this.pin=pin;

        setLayout(null);

        JLabel text = new JLabel("PLEASE SELECT YOUR TRANSACTION");
        text.setFont(new Font("Osward", Font.BOLD, 20));
        text.setBounds(200,40,450,40);
        add(text);

        deposit = new JButton ("DEPOSIT");
        deposit.setBounds (120,150,180,40);
        deposit.setBackground(Color.black);
        deposit.setForeground(Color.white);
        deposit.addActionListener(this);
        add (deposit);

        withdrawl = new JButton ("WITHDRAWL");
        withdrawl.setBounds (120,220,180,40);
        withdrawl.setBackground(Color.black);
        withdrawl.setForeground(Color.white);
        withdrawl.addActionListener(this);
        add (withdrawl);

        fastcash = new JButton ("FAST CASH");
        fastcash.setBounds (120,290,180,40);
        fastcash.setBackground(Color.black);
        fastcash.setForeground(Color.white);
        fastcash.addActionListener(this);
        add (fastcash);

        pinchange = new JButton ("PIN CHANGE");
        pinchange.setBounds (500,220,180,40);
        pinchange.setBackground(Color.black);
        pinchange.setForeground(Color.white);
        pinchange.addActionListener(this);
        add (pinchange);

        baleq = new JButton ("BALANCE ENQUIRY");
        baleq.setBounds (500,150,180,40);
        baleq.setBackground(Color.black);
        baleq.setForeground(Color.white);
        baleq.addActionListener(this);
        add (baleq);

        exit = new JButton ("EXIT");
        exit.setBounds (500,290,180,40);
        exit.setBackground(Color.black);
        exit.setForeground(Color.white);
        exit.addActionListener(this);
        add (exit);

        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize (800,480);
        setVisible (true);
        setLocation (310,100);  
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== exit){ 
            System.exit(0);  
        }else if (ae.getSource () == deposit){
            setVisible(false);
            new Deposit(pin).setVisible (true);
        }else if (ae.getSource () == withdrawl){
            setVisible(false);
            new Withdrawl(pin).setVisible (true);
        }else if (ae.getSource () == fastcash){
            setVisible(false);
            new FastCash(pin).setVisible (true);
        }else if (ae.getSource () == pinchange){
            setVisible(false);
            new PinChange(pin).setVisible (true);
        }else if (ae.getSource () == baleq){
            setVisible(false);
            new BalanceEnquiry(pin).setVisible (true);
        }
    }
    
    public static void main(String[] args) {
        new Transaction("").setVisible (true);
    }
}

