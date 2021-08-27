package com.login.Dao;

import com.login.model.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ValidStudentDao {
    
    Student student = new Student();
    
    public Student getStudent(String userName, int rollNo, String passWord){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "hello123");
            String query = "select * from student where userNameStu = ? and rollNoStu = ? and passWordStu = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, userName);
            ps.setInt(2, rollNo);
            ps.setString(3, passWord);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                
                student.setUserName(rs.getString(1));
                student.setRollNo(rs.getInt(2));
                student.setPassWord(rs.getString(3));
                return student;
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
