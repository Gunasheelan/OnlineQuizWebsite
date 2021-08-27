package com.login.servlet;

import com.login.Dao.ValidAdminDao;
import com.login.model.Admin;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "ValidAdmin", urlPatterns = {"/ValidAdmin"})
public class ValidAdmin extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        
        ValidAdminDao dao = new ValidAdminDao();
        
        Admin admin = dao.getAdmin(userName, passWord);
        try{
            System.out.println(admin.getUserName());
            System.out.println(admin.getPassWord());
            
            if(admin.getUserName().equals(userName) && admin.getPassWord().equals(passWord)){
                HttpSession session = request.getSession();
                session.setAttribute("userName", admin.getUserName());
            
                response.sendRedirect("CreateTestID.jsp");
            }
            else{
                request.setAttribute("errorMessageAdmin", "<br><div class=\"alert alert-danger\" role=\"alert\">\n" +
"                    Enter Valid Username and Password!\n" +
"                  </div>");
//                RequestDispatcher rd =  request.getRequestDispatcher("Index.jsp");
//                rd.forward(request, response);
//                    or
                request.getRequestDispatcher("Index.jsp").forward(request, response);
            }
        }
        catch(Exception e){
            request.setAttribute("errorMessageAdmin", "<br><div class=\"alert alert-danger\" role=\"alert\">\n" +
"                    Enter Valid Username and Password!\n" +
"                  </div>");
                request.getRequestDispatcher("Index.jsp").forward(request, response);
            }
                
    }
}

