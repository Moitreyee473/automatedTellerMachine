package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.sql.*;



public class SignupOne extends JFrame implements ActionListener {

    
    Random ran = new Random();
    long random = (ran.nextLong()%9000L)+1000L;
    String form = ""+Math.abs(random);
    JLabel formno, personaldetails, name, fname, dob, gender, email, marital, address, city, state, pincode;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton male,female,others,married,unmarried,other;
    JDateChooser dateChooser;

    SignupOne(){

        setLayout(null);



        formno= new JLabel ("APPLICATION FORM NO.:" +random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140,20,600,40);
        add(formno);

        personaldetails= new JLabel ("Page 1: Personal Details");
        personaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personaldetails.setBounds(290,60,400,30);
        add(personaldetails);

        name= new JLabel ("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,120,100,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont (new Font("Raleway", Font.BOLD,14));
        nameTextField.setBounds(300,120,200,30);
        add(nameTextField);

        fname= new JLabel ("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,160,200,30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont (new Font("Raleway", Font.BOLD,14));
        fnameTextField.setBounds(300,160,200,30);
        add(fnameTextField);

        dob= new JLabel ("Date Of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,200,200,30);
        add(dob);

        dateChooser =  new JDateChooser();
        dateChooser.setBounds (300,200,200,30);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);

        gender= new JLabel ("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,240,200,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 240, 60, 30);
        male.setBackground(Color.WHITE);
        add (male);
        female = new JRadioButton("Female");
        female.setBounds(450, 240, 120, 30);
        female.setBackground(Color.WHITE);
        add (female);
        others = new JRadioButton("Others");
        others.setBounds(630, 240, 180, 30);
        others.setBackground(Color.WHITE);
        add (others);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(others);

        email= new JLabel ("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,280,200,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont (new Font("Raleway", Font.BOLD,14));
        emailTextField.setBounds(300,280,200,30);
        add(emailTextField);

        marital= new JLabel ("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,320,200,30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 320, 100, 30);
        married.setBackground(Color.WHITE);
        add (married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 320, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add (unmarried);
        other = new JRadioButton("Other");
        other.setBounds(630, 320, 100, 30);
        other.setBackground(Color.WHITE);
        add (other);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);

        address= new JLabel ("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,360,200,30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont (new Font("Raleway", Font.BOLD,14));
        addressTextField.setBounds(300,360,200,30);
        add(addressTextField);

        city= new JLabel ("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,400,200,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont (new Font("Raleway", Font.BOLD,14));
        cityTextField.setBounds(300,400,200,30);
        add(cityTextField);

        state= new JLabel ("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,440,200,30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont (new Font("Raleway", Font.BOLD,14));
        stateTextField.setBounds(300,440,200,30);
        add(stateTextField);

        pincode= new JLabel ("Pin Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100,480,200,30);
        add(pincode);

        pinTextField = new JTextField();
        pinTextField.setFont (new Font("Raleway", Font.BOLD,14));
        pinTextField.setBounds(300,480,200,30);
        add(pinTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,540, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane() .setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize (800, 700);
        setLocation (250, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String formno= form;
        String name= nameTextField.getText();
        String fname= fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){ 
            gender = "Male";
        }else if(female.isSelected()){ 
            gender = "Female";
        }
        String email=emailTextField.getText();
        String marital = null;
        if(married.isSelected()){ 
            marital = "Married";
        }else if(unmarried.isSelected()){ 
            marital = "Unmarried";
        }else if(other.isSelected()){ 
            marital = "Other";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pinTextField.getText();

        try{
            if (name.equals("")||fname.equals("")||dob.equals("")||email.equals("")||address.equals("")||city.equals("")||pincode.equals("")||state.equals(""))
            JOptionPane.showMessageDialog(null, "All fields are mandatory.");
           else{
                //try{
                    Conn c= new Conn();
                    String query=  "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"', '"+state+"')";
                    c.s.executeUpdate(query);
                    
                    JOptionPane.showMessageDialog(null,"Record Saved Successfully");

                    setVisible(false);
                    new SignupTwo(form).setVisible(true);

                //}
                
                
            }

        }catch (Exception e1){
            System.out.println (e1);
        }
        

    }

    public static void main (String[] args) {
        new SignupOne();
    }
    
}
