package com.login.Dao;

import com.login.model.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TestIDDao {
    
    public List<Test> getTest(String testID){
        List<Test> test = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/questions", "root", "hello123");
            String query = "select * from "+ testID +";";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                int queNo = rs.getInt(1);
                String question = rs.getString(2);
                String option1 = rs.getString(3);
                String option2 = rs.getString(4);
                String option3 = rs.getString(5);
                String option4 = rs.getString(6);
                String correctAnswer = rs.getString(7);
                
                Test tempTest = new Test(queNo, question, option1, option2, option3, option4, correctAnswer);
                test.add(tempTest);
            }
            return test;
        } 
        catch (Exception e) {
            return null;
//            System.out.println(e);
        }
        
//        return null;
    }
    
    public int getCount(String testID){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/questions", "root", "hello123");
            String query = "select count(*) from "+ testID +";";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int rowCount = rs.getInt(1);
            return rowCount;
        } 
        catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    
}
