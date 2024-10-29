package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{

    JButton hundred, fivehund, thousand, twothou, fivethou, tenthou, back;
    String pin;

    FastCash(String pin){

        this.pin=pin;

        setLayout(null);

        JLabel text = new JLabel("Select Withdrawl Amount:");
        text.setFont(new Font("Osward", Font.BOLD, 20));
        text.setBounds(200,40,450,40);
        add(text);

        hundred = new JButton ("Rs 100");
        hundred.setBounds (120,150,180,40);
        hundred.setBackground(Color.black);
        hundred.setForeground(Color.white);
        hundred.addActionListener(this);
        add (hundred);

        fivehund = new JButton ("Rs 500");
        fivehund.setBounds (120,220,180,40);
        fivehund.setBackground(Color.black);
        fivehund.setForeground(Color.white);
        fivehund.addActionListener(this);
        add (fivehund);

        thousand = new JButton ("Rs 1000");
        thousand.setBounds (120,290,180,40);
        thousand.setBackground(Color.black);
        thousand.setForeground(Color.white);
        thousand.addActionListener(this);
        add (thousand);

        twothou = new JButton ("Rs 2000");
        twothou.setBounds (500,150,180,40);
        twothou.setBackground(Color.black);
        twothou.setForeground(Color.white);
        twothou.addActionListener(this);
        add (twothou);

        fivethou = new JButton ("Rs 5000");
        fivethou.setBounds (500,220,180,40);
        fivethou.setBackground(Color.black);
        fivethou.setForeground(Color.white);
        fivethou.addActionListener(this);
        add (fivethou);

        tenthou = new JButton ("Rs 10000");
        tenthou.setBounds (500,290,180,40);
        tenthou.setBackground(Color.black);
        tenthou.setForeground(Color.white);
        tenthou.addActionListener(this);
        add (tenthou);

        back = new JButton ("BACK");
        back.setBounds (350,360,120,40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add (back);

        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize (800,480);
        setVisible (true);
        setLocation (310,100);  
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== back){ 
            setVisible(false);
            new  Transaction(pin).setVisible(true);
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c =new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin='"+pin+"'");
                int balance =0;
                while (rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance +=  Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -=  Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if (ae.getSource()!= back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date  b_date= new Date();
                String query = "insert into bank values('"+pin+"', '"+b_date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");

                setVisible(false);
                new Transaction(pin).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String[] args) {
        new FastCash("");
    }
}
