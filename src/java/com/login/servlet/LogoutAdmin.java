package com.login.servlet;

import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "LogoutAdmin", urlPatterns = {"/LogoutAdmin"})
public class LogoutAdmin extends HttpServlet {

    @Override
    protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("userName");
        session.invalidate();
        response.sendRedirect("Index.jsp");
    }

}
