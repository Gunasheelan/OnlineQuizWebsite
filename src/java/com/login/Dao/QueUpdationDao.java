package com.login.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueUpdationDao {
    
    public boolean addQuestion(String testID, String question, String option1, String option2, String option3, String option4, String correctAnswer){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/questions", "root", "hello123");
            
            String query = "insert into "+testID+" (question, option1, option2, option3, option4, correctAnswer) values (?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, question);
            ps.setString(2, option1);
            ps.setString(3, option2);
            ps.setString(4, option3);
            ps.setString(5, option4);
            ps.setString(6, correctAnswer);
            
            int count = ps.executeUpdate();
            if(count > 0){
                return true;
            }
            ps.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    
    public int rowCount(String testID){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/questions", "root", "hello123");
            
            String que = "select count(*) from "+ testID +";";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(que);
            rs.next();
            int row = rs.getInt(1);
            System.out.println(row);
            return row;
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        return 0;
    }
    
}
