package com.login.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SignupStudentDao {
    public boolean signUpStudent(String userName, int rollNo, String passWord){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "hello123");
            String query = "insert into student (userNameStu, rollNoStu, passwordStu) values(?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, userName);
            ps.setInt(2, rollNo);
            ps.setString(3, passWord);
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
