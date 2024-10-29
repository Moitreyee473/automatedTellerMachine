package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class SignupTwo extends JFrame implements ActionListener {

    long random;
    String formno;
    JTextField panTextField, adharTextField;
    JButton next;
    JRadioButton syes,sno,eyes, eno;
    JComboBox <String> cat,occ,i,eq, r;
    

    SignupTwo(String formno){

        this.formno = formno;

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM: PAGE 2");

        JLabel additionaldetails= new JLabel ("Page 2: Additional Details");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionaldetails.setBounds(290,60,400,30);
        add(additionaldetails);

        JLabel religion= new JLabel ("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100,120,100,30);
        add(religion);

        String Religion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        r = new JComboBox<>(Religion);
        r.setBackground(Color.WHITE);
        r.setBounds(300,120,200,30);
        add(r);
        
        JLabel category= new JLabel ("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100,160,200,30);
        add(category);

        String Category[] = {"General","OBC","SC","ST","Other"};
        cat = new JComboBox<>(Category);
        cat.setBackground(Color.WHITE);
        cat.setBounds(300,160,200,30);
        add(cat);

        JLabel income= new JLabel ("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100,200,200,30);
        add(income);

        String Income[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        i = new JComboBox<>(Income);
        i.setBackground(Color.WHITE);
        i.setBounds(300,200,200,30);
        add(i);

        JLabel education= new JLabel ("Educational");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100,240,200,30);
        add(education);

        JLabel qualification= new JLabel ("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100,260,200,30);
        add(qualification);

        String EQ[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        eq = new JComboBox<>(EQ);
        eq.setBackground(Color.WHITE);
        eq.setBounds(300,250,200,30);
        add(eq);

        JLabel  occupation= new JLabel ("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100,320,200,30);
        add(occupation);

        String Occupation[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        occ = new JComboBox<>(Occupation);
        occ.setBackground(Color.WHITE);
        occ.setBounds(300,320,200,30);
        add(occ);

        JLabel panno= new JLabel ("Pan No.:");
        panno.setFont(new Font("Raleway", Font.BOLD, 20));
        panno.setBounds(100,360,200,30);
        add(panno);

        panTextField = new JTextField();
        panTextField.setFont (new Font("Raleway", Font.BOLD,14));
        panTextField.setBounds(300,360,200,30);
        add(panTextField);

        JLabel adharno= new JLabel ("Aadhar No:");
        adharno.setFont(new Font("Raleway", Font.BOLD, 20));
        adharno.setBounds(100,400,200,30);
        add(adharno);

        adharTextField = new JTextField();
        adharTextField.setFont (new Font("Raleway", Font.BOLD,14));
        adharTextField.setBounds(300,400,200,30);
        add(adharTextField);

        JLabel seniorcitizen= new JLabel ("Senior Citizen:");
        seniorcitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorcitizen.setBounds(100,440,200,30);
        add(seniorcitizen);

        syes= new JRadioButton("Yes");
        syes.setBounds(300, 440, 100, 30);
        syes.setBackground(Color.WHITE);
        add (syes);
        sno= new JRadioButton("No");
        sno.setBounds(400, 440, 100, 30);
        sno.setBackground(Color.WHITE);
        add (sno);
        ButtonGroup sen_cit = new ButtonGroup();
        sen_cit.add(syes);
        sen_cit.add(sno);

        JLabel existingacc= new JLabel ("Existing Account:");
        existingacc.setFont(new Font("Raleway", Font.BOLD, 20));
        existingacc.setBounds(100,480,200,30);
        add(existingacc);

        eyes= new JRadioButton("Yes");
        eyes.setBounds(300, 480, 100, 30);
        eyes.setBackground(Color.WHITE);
        add (eyes);
        eno= new JRadioButton("No");
        eno.setBounds(400, 480, 100, 30);
        eno.setBackground(Color.WHITE);
        add (eno);
        ButtonGroup exist_acc = new ButtonGroup();
        exist_acc.add(eyes);
        exist_acc.add(eno);

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
        //String formno= ""+random;
        String sreligion= (String) r.getSelectedItem();
        String scategory= (String) cat.getSelectedItem();
        String sincome = (String) i.getSelectedItem();
        String sedu = (String) eq.getSelectedItem();
        String soccupation = (String) occ.getSelectedItem();
        String s_sencit = null;
        if(syes.isSelected()){ 
            s_sencit = "Yes";
        }else if(sno.isSelected()){ 
            s_sencit = "No";
        }
        String s_existacc = null;
        if(eyes.isSelected()){ 
            s_existacc = "Yes";
        }else if(eno.isSelected()){ 
            s_existacc = "No";
        }
        String span = panTextField.getText();
        String sadhar = adharTextField.getText();

        try{
            if (sreligion.equals("")||sincome.equals("")||scategory.equals("")||sedu.equals("")||soccupation.equals("")||s_sencit.equals("")||s_existacc.equals("")||span.equals("")||sadhar.equals(""))
            JOptionPane.showMessageDialog(null, "All fields are mandatory.");
            else{
                //try{
                    Conn c= new Conn();
                    String query=  "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+sedu+"','"+soccupation+"','"+span+"','"+sadhar+"','"+s_sencit+"','"+s_existacc+"')";
                    c.s.executeUpdate(query);                   
                    JOptionPane.showMessageDialog(null,"Record Saved Successfully");

                    setVisible(false);
                    new SignupThree(formno).setVisible(true);

                //}
                
                
            }

        }catch (Exception e1){
            System.out.println (e1);
        }

    }

    public static void main (String[] args) {
        new SignupTwo("");
    }
    
}
