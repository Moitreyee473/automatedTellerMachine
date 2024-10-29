package bank.management.system;

import java.sql.*; 
import java.sql.Connection; 


public class Conn{
    Connection c;
    Statement s;
    public Conn(){  
        try{  
            //Class.forName("com.jdbc.cj.Driver");  
            //DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","pass");    
            s =c.createStatement(); 
        }catch(Exception e){ 
            System.out.println(e);
        }
    }  
}  

