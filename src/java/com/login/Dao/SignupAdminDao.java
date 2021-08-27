package com.login.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SignupAdminDao {
    
    public boolean signUpAdmin(String userName, String passWord){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "hello123");
            String query = "insert into admin (aUserName, aPassword) values(?, ?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, passWord);
            int count = ps.executeUpdate();
            if(count > 0)
                return true;
            }
        catch(Exception e){
                System.out.println(e);
            }
        return false;
    }
    
}
