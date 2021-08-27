package com.login.servlet;

import com.login.Dao.SignupStudentDao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.InputMismatchException;
import java.util.regex.Pattern;

@WebServlet(name = "SignupStudent", urlPatterns = {"/SignupStudent"})
public class SignupStudent extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try{
            String userName = request.getParameter("userName");
            int rollNo = Integer.parseInt(request.getParameter("rollNo"));
            String passWord = request.getParameter("passWord");

            if(Pattern.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{4,}", passWord)){
                    SignupStudentDao sdao = new SignupStudentDao();
                    if(sdao.signUpStudent(userName, rollNo, passWord)){
                        HttpSession session = request.getSession();
                        session.setAttribute("userName", userName);
//                        session.setAttribute("rollNo", rollNo);
//                        session.setAttribute("passWord", passWord);
                        response.sendRedirect("EnterTestIDStudent.jsp");
                    }
                    else{
                         request.setAttribute("errorMessage", "<br><div class=\"alert alert-danger\" role=\"alert\">\n" +
    "                    RollNo Already taken!\n" +
    "                  </div>");
                         request.getRequestDispatcher("SignupStudent.jsp").forward(request, response);
                    }
            }
            else{
                request.setAttribute("errorMessage", "<br><div class=\"alert alert-danger\" role=\"alert\">\n" +
    "                    Password must contain atleast 4 characters with atleast 1 Uppercase, 1 Lowercase, 1 Digit!\n" +
    "                  </div>");
                request.getRequestDispatcher("SignupStudent.jsp").forward(request, response);
            }
        }
        catch(InputMismatchException e){
             request.setAttribute("errorMessage", "<br><div class=\"alert alert-danger\" role=\"alert\">\n" +
"                    RollNo must be a Digit!\n" +
"                  </div>");
            request.getRequestDispatcher("SignupStudent.jsp").forward(request, response);
        }
        
    }

}
