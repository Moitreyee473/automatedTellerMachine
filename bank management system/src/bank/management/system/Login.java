package bank.management.system;

//import bank.management.system.Conn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JButton login, signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login(){
        setTitle("WELCOME TO OUR BANK");
        
        setLayout (null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(70, 10, 100, 100);
        add(l1);
        
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200,40,450,40);
        add(text);
        
        JLabel cardno = new JLabel("CARD NO:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120,150,150,40);
        add(cardno);
        
        cardTextField= new JTextField(15);
        cardTextField.setBounds(300,150,230,40);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120,220,250,30);
        add(pin);
        
        pinTextField= new JPasswordField(15);
        pinTextField.setBounds(300,220,230,40);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        login = new JButton ("SIGN IN");
        login.setBounds (300,300,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add (login);
        
        clear = new JButton ("CLEAR");
        clear.setBounds (430,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add (clear);
        
        signup = new JButton ("SIGN UP");
        signup.setBounds (300,350,230,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add (signup);

        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize (800,480); //frame length breadth
        setVisible (true);
        setLocation (310,100);    
    }
    
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if (ae.getSource() == login){
            Conn conn = new Conn();
            String cardno  = cardTextField.getText();
            String pin  = pinTextField.getText();
            String query  = "select * from login where cardnumber = '"+cardno+"' and pin = '"+pin+"'";
            try{
               ResultSet rs= conn.s.executeQuery(query);
               if (rs.next()) {
                setVisible(false);
                new Transaction(pin).setVisible(true);
               }else{
                JOptionPane.showMessageDialog(null, "Incorrect Card No. or Pin");
               }
            }catch (Exception e){
                System.out.println(e);
            }
        }else if (ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    
    public static void main (String[] args){
        new Login();
    }
}

