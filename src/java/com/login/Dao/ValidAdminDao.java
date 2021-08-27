package com.login.Dao;

import com.login.model.Admin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ValidAdminDao {
    
    public Admin getAdmin(String userName, String passWord){
        Admin admin = new Admin();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "hello123");
            String query = "select * from admin where aUsername = ? and aPassword = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, passWord);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                admin.setUserName(rs.getString(1));
                admin.setPassWord(rs.getString(2));
                return admin;
            }
            
            ps.close();
            rs.close();
            }
        catch(Exception e){
                System.out.println(e);
            }
        return null;
    }
    
}