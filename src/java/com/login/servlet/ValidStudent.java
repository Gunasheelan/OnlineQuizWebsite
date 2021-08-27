package com.login.servlet;

import com.login.Dao.ValidStudentDao;
import com.login.model.Student;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "ValidStudent", urlPatterns = {"/ValidStudent"})
public class ValidStudent extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try{
            
        String userName = request.getParameter("userName");
        int rollNo = Integer.parseInt(request.getParameter("rollNo"));
        String passWord = request.getParameter("passWord");
        
        ValidStudentDao dao = new ValidStudentDao();
        Student student = dao.getStudent(userName, rollNo, passWord);
        
            System.out.println(student.getUserName());
            System.out.println(student.getPassWord());
            
            if(student.getUserName().equals(userName) && student.getPassWord().equals(passWord) && student.getRollNo() == rollNo){
                HttpSession session = request.getSession();
                session.setAttribute("userName", student.getUserName());
            
                response.sendRedirect("EnterTestIDStudent.jsp");
            }
            else{
                request.setAttribute("errorMessageStudent", "<br><div class=\"alert alert-danger\" role=\"alert\">\n" +
"                    Enter Valid Username, RollNo and Password!\n" +
"                  </div>");
                request.getRequestDispatcher("Index.jsp").forward(request, response);
            }
        }
        catch(NumberFormatException e)
        {
            request.setAttribute("errorMessageStudent", "<br><div class=\"alert alert-danger\" role=\"alert\">\n" +
"                    RollNo must be a Digit!\n" +
"                  </div>");
            request.getRequestDispatcher("Index.jsp").forward(request, response);
        }
        catch(Exception e){
            request.setAttribute("errorMessageStudent", "<br><div class=\"alert alert-danger\" role=\"alert\">\n" +
"                    Enter Valid Username, RollNo and Password!\n" +
"                  </div>");
                request.getRequestDispatcher("Index.jsp").forward(request, response);
            }
    }

}
