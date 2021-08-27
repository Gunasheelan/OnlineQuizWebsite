package com.login.servlet;

import com.login.Dao.ForgotPasswordAdminDao;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Pattern;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "ForgotPasswordAdmin", urlPatterns = {"/ForgotPasswordAdmin"})
public class ForgotPasswordAdmin extends HttpServlet {

    @Override
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String confirmpassWord = request.getParameter("confirmpassWord");
        
        if (passWord.equals(confirmpassWord)) {
            if(Pattern.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{4,}", passWord))
            {
                ForgotPasswordAdminDao fdao = new ForgotPasswordAdminDao();
                
                if(fdao.passUpdateAdmin(userName, passWord)){
                    HttpSession session = request.getSession();
                    session.setAttribute("userName", userName);
                    response.sendRedirect("CreateTestID.jsp");
                    }
                    else{
                        request.setAttribute("errorMessage", "<br><div class=\"alert alert-danger\" role=\"alert\">\n" +
    "                    Enter existing Username!\n" +
    "                  </div>");
                        request.getRequestDispatcher("ForgotPasswordAdmin.jsp").forward(request, response);
                }
           }
           else{
                request.setAttribute("errorMessage", "<br><div class=\"alert alert-danger\" role=\"alert\">\n" +
"                    Password must contain atleast 4 characters with atleast 1 Uppercase, 1 Lowercase, 1 Digit!\n" +
"                  </div>");
                    request.getRequestDispatcher("ForgotPasswordAdmin.jsp").forward(request, response);
                }
         
        }
        else{
            request.setAttribute("errorMessage", "<br><div class=\"alert alert-danger\" role=\"alert\">\n" +
"                    Enter Same Password for Both!\n" +
"                  </div>");
            request.getRequestDispatcher("ForgotPasswordAdmin.jsp").forward(request, response);
        }
    }

}
