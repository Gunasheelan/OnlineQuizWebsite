package com.login.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestIDCreationDao {
    
    public boolean createTestID(String testID){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/questions", "root", "hello123");
            String query = "create table "+testID+"(queNO int primary key not null auto_increment, question varchar(1000) not null, option1 varchar(500) not null, option2 varchar(500) not null, option3 varchar(500) not null, option4 varchar(500) not null,correctAnswer varchar(500) not null);";
            Statement ps = con.createStatement();
            int count = ps.executeUpdate(query);
            
            if(count >= 0){
               return true;
            }
//            or
//            boolean b = ps.execute(query);
//            if(b){
//                return true;
//            }
            ps.close();
            }
        catch(Exception e){
                System.out.println(e);
            }
        return false;
    }
    
}
