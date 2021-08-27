package com.login.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ForgotPasswordStudentDao {
    public boolean passUpdateStudent(String userName, int rollNo, String passWord){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "hello123");
            String query = "update student set passwordStu = ? where userNameStu = ? and rollNoStu = ?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, passWord);
            ps.setString(2, userName);
            ps.setInt(3, rollNo);
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
