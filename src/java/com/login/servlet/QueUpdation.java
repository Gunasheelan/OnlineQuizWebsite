package com.login.servlet;

import com.login.Dao.QueUpdationDao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "QueUpdation", urlPatterns = {"/QueUpdation"})
public class QueUpdation extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String question = request.getParameter("question");
        String option1 = request.getParameter("option1");
        String option2 = request.getParameter("option2");
        String option3 = request.getParameter("option3");
        String option4 = request.getParameter("option4");
        String correctAnswer = request.getParameter("correctAnswer");
        
        HttpSession session = request.getSession();
        String testID = session.getAttribute("testID").toString();
        int noofQue = (int) session.getAttribute("noofQue");
        
        QueUpdationDao dao = new QueUpdationDao();
        int row = dao.rowCount(testID);
        
        if(dao.addQuestion(testID, question, option1, option2, option3, option4, correctAnswer)){
            session.setAttribute("row", row);
            if(row + 1 == noofQue){
                response.sendRedirect("Success.jsp");
            }
            else{
                response.sendRedirect("AddQuestion.jsp");
            }
        }
            else{
                request.setAttribute("errorMessage", "<div class=\"alert alert-danger\" role=\"alert\">\n" +
"                    Something went wrong!\n" +
"                  </div>");
            request.getRequestDispatcher("CreateTestID.jsp").forward(request, response);
            }

    }

}
