package com.login.servlet;

import com.login.Dao.ForgotPasswordAdminDao;
import com.login.Dao.ForgotPasswordStudentDao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.InputMismatchException;
import java.util.regex.Pattern;


@WebServlet(name = "ForgotPasswordStudent", urlPatterns = {"/ForgotPasswordStudent"})
public class ForgotPasswordStudent extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String userName = request.getParameter("userName");
            int rollNo = Integer.parseInt(request.getParameter("rollNo"));
            String passWord = request.getParameter("passWord");
            String confirmpassWord = request.getParameter("confirmpassWord");

            if (passWord.equals(confirmpassWord)) {
                if(Pattern.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{4,}", passWord))
                {
                    ForgotPasswordStudentDao fdao = new ForgotPasswordStudentDao();

                    if(fdao.passUpdateStudent(userName, rollNo, passWord)){
                        HttpSession session = request.getSession();
                        session.setAttribute("userName", userName);
                        response.sendRedirect("EnterTestIDStudent.jsp");
                        }
                        else{
                            request.setAttribute("errorMessage", "<br><div class=\"alert alert-danger\" role=\"alert\">\n" +
        "                    Enter existing Username and RollNo!\n" +
        "                  </div>");
                            request.getRequestDispatcher("ForgotPasswordStudent.jsp").forward(request, response);
                    }
               }
               else{
                    request.setAttribute("errorMessage", "<br><div class=\"alert alert-danger\" role=\"alert\">\n" +
    "                    Password must contain atleast 4 characters with atleast 1 Uppercase, 1 Lowercase, 1 Digit!\n" +
    "                  </div>");
                        request.getRequestDispatcher("ForgotPasswordStudent.jsp").forward(request, response);
                    }

            }
            else{
                request.setAttribute("errorMessage", "<br><div class=\"alert alert-danger\" role=\"alert\">\n" +
    "                    Enter Same Password for Both!\n" +
    "                  </div>");
                request.getRequestDispatcher("ForgotPasswordStudent.jsp").forward(request, response);
            }
        }
        catch(InputMismatchException e){
            request.setAttribute("errorMessage", "<br><div class=\"alert alert-danger\" role=\"alert\">\n" +
    "                    RollNo must be a Digit!\n" +
    "                  </div>");
                request.getRequestDispatcher("ForgotPasswordStudent.jsp").forward(request, response);
        }
    }

}
