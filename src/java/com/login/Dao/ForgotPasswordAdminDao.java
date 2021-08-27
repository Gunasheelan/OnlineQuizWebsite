package com.login.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ForgotPasswordAdminDao {
    
    public boolean passUpdateAdmin(String userName, String passWord){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "hello123");
            String query = "update admin set aPassword = ? where aUserName = ?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, passWord);
            ps.setString(2, userName);
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

    
}
