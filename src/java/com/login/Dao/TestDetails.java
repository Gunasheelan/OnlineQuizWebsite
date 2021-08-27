package com.login.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestDetails {
    public boolean insertTestCount(String userName, String testID){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/answers", "root", "hello123");
            
            String query2 = "select * from testcount2 where userName = ? and testID = ?;";
            PreparedStatement ps2 = con.prepareStatement(query2);
            ps2.setString(1, userName);
            ps2.setString(2, testID);
            ResultSet rs = ps2.executeQuery();
            
            if(rs.next()){
                return false;
            }
            
            int zero = 0;
            String query = "insert into testcount2 values (?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, testID);
            ps.setInt(3, zero);
            int count = ps.executeUpdate();
            if(count > 0){
                return true;
            }
            
        } 
        catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public int showMark(String userName, String testID){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/answers", "root", "hello123");
            
            String query2 = "select mark from testcount2 where userName = ? and testID = ?;";
            PreparedStatement ps2 = con.prepareStatement(query2);
            ps2.setString(1, userName);
            ps2.setString(2, testID);
            ResultSet rs = ps2.executeQuery();
            rs.next();
            
            return rs.getInt(1);
        } 
        catch (Exception e) {
            System.out.println(e);
        }
        
        return 0;
        
    }
    
    public void updateMark(String userName, String testID, int mark){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/answers", "root", "hello123");
            
            String query2 = " update testcount2 set mark = "+mark+" where userName = ? and testID = ?;";
            PreparedStatement ps2 = con.prepareStatement(query2);
            ps2.setString(1, userName);
            ps2.setString(2, testID);
            int rs = ps2.executeUpdate();
            
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
