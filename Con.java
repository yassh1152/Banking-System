package Bank;



import java.sql.*;

public class Con {
    Connection cn;
    Statement st;
    public Con(){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","yash");
            st = cn.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}