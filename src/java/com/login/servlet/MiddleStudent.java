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

@WebServlet(name = "MiddleStudent", urlPatterns = {"/MiddleStudent"})
public class MiddleStudent extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ans = request.getParameter("option");
//        if(ans == null){
//            response.sendRedirect("TestPage2.jsp");
//        }
        HttpSession session = request.getSession();

        String testID = session.getAttribute("testID").toString();
        String userName = session.getAttribute("userName").toString();
        
        int num = Integer.parseInt(session.getAttribute("num").toString());
//        System.out.println(num + " num middle");
        int noOfQue = Integer.parseInt(session.getAttribute("noOfQue").toString());
        System.out.println(noOfQue + " noofque");
        if(num < noOfQue){
        

        TestIDDao dao = new TestIDDao();
        List<Test> students = dao.getTest(testID);

        Test t = students.get(num);
        Test t2 = students.get(num - 1);
            System.out.println(ans + " ans");
        System.out.println(t2.getCorrectAnswer() + " correct answer");
        if(ans != null){
        if(ans.equals(t2.getCorrectAnswer())){
            TestDetails testDao = new TestDetails();
            int mark = testDao.showMark(userName, testID);
            testDao.updateMark(userName, testID, (mark + 1));
        }
        }
//            System.out.println(mark + " mark");
//        System.out.println(t.getQueNo()+ " que no middle");
        
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
            System.out.println(ans + " ans");
            TestIDDao dao = new TestIDDao();
            List<Test> students = dao.getTest(testID);
            
            Test t3 = students.get(noOfQue - 1);
            System.out.println(t3.getCorrectAnswer() + " correct answer");
            if(ans != null){
            if(ans.equals(t3.getCorrectAnswer())){
                TestDetails testDao = new TestDetails(); // getting ans and updatins ans
                int mark = testDao.showMark(userName, testID);
                testDao.updateMark(userName, testID, (mark + 1));
                
            }   
        }
            TestDetails testDao = new TestDetails();
            int mark = testDao.showMark(userName, testID);
            session.setAttribute("mark", mark);
            response.sendRedirect("Result.jsp");
        }

    }

}
