package com.login.servlet;

import com.login.Dao.TestDetails;
import com.login.Dao.TestIDDao;
import com.login.model.Test;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@WebServlet(name = "ValidTestIDStudent", urlPatterns = {"/ValidTestIDStudent"})
public class ValidTestIDStudent extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try{
            
        String testID = request.getParameter("testID");
        System.out.println(testID);
        HttpSession session = request.getSession();
        String userName = session.getAttribute("userName").toString();
        TestDetails daotest = new TestDetails();
        if(daotest.insertTestCount(userName, testID)){
        
        
        TestIDDao dao = new TestIDDao();
        List<Test> students = dao.getTest(testID);
        int noOfQue = dao.getCount(testID);
        
        if(students != null){
           
            session.setAttribute("testID", testID);
            session.setAttribute("noOfQue", noOfQue);
            session.setAttribute("studentsList", students);
            
                Test t = students.get(0);
                
                session.setAttribute("noofQue", dao.getCount(testID));
                
                session.setAttribute("queNo", t.getQueNo());
                session.setAttribute("question", t.getQuestion());
                session.setAttribute("option1", t.getOption1());
                session.setAttribute("option2", t.getOption2());
                session.setAttribute("option3", t.getOption3());
                session.setAttribute("option4", t.getOption4());
                
                response.sendRedirect("TestPageStudent.jsp");
        }
        else{
            request.setAttribute("errorMessage", "<br><div class=\"alert alert-danger\" role=\"alert\">\n" +
"                    Enter Valid TestID!\n" +
"                  </div>");
            request.getRequestDispatcher("EnterTestIDStudent.jsp").forward(request, response);
        }
    }
        else{
            request.setAttribute("errorMessage", "<br><div class=\"alert alert-danger\" role=\"alert\">\n" +
"                    You've attended the test already!\n" +
"                  </div>");
            request.getRequestDispatcher("EnterTestIDStudent.jsp").forward(request, response);
            
        }
        }
        catch(IndexOutOfBoundsException e){
            request.setAttribute("errorMessage", "<br><div class=\"alert alert-danger\" role=\"alert\">\n" +
"                    There is no questions available in this TestID!\n" +
"                  </div>");
            request.getRequestDispatcher("EnterTestIDStudent.jsp").forward(request, response);
        }

    }

}
