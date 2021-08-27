package com.login.servlet;

import com.login.Dao.SignupAdminDao;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Pattern;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SignupAdmin", urlPatterns = {"/SignupAdmin"})
public class SignupAdmin extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        
        if(Pattern.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{4,}", passWord)){
                SignupAdminDao sdao = new SignupAdminDao();
                if(sdao.signUpAdmin(userName, passWord)){
                    HttpSession session = request.getSession();
                    session.setAttribute("userName", userName);
                    session.setAttribute("passWord", passWord);
                    response.sendRedirect("CreateTestID.jsp");
                }
                else{
                     request.setAttribute("errorMessage", "<br><div class=\"alert alert-danger\" role=\"alert\">\n" +
"                    UserName Already taken!\n" +
"                  </div>");
                     request.getRequestDispatcher("SignupAdmin.jsp").forward(request, response);
                }
        }
        else{
            request.setAttribute("errorMessage", "<br><div class=\"alert alert-danger\" role=\"alert\">\n" +
"                    Password must contain atleast 4 characters with atleast 1 Uppercase, 1 Lowercase, 1 Digit!\n" +
"                  </div>");
            request.getRequestDispatcher("SignupAdmin.jsp").forward(request, response);
        }
    }

}
