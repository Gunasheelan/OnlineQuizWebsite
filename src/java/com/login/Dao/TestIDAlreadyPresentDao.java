package com.login.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestIDAlreadyPresentDao {
    
    public boolean alreadyPresent(String testID){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/questions", "root", "hello123");
            
            String query = "desc "+ testID+";";
            PreparedStatement ps = con.prepareStatement(query);
//            ps.setString(1, testID);
            int count = ps.executeUpdate();
            if(count > 0){
                return true;
            }
            ps.close();
        }
        catch(Exception e){
            return false;
            
        }
        return false;
    }
    
}
