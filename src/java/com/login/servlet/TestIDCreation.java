package com.login.servlet;

import com.login.Dao.TestIDAlreadyPresentDao;
import com.login.Dao.TestIDCreationDao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.regex.Pattern;

@WebServlet(name = "TestIDCreation", urlPatterns = {"/TestIDCreation"})
public class TestIDCreation extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String testID = request.getParameter("testID");
            int noofQue = Integer.parseInt(request.getParameter("noofQuestions"));
            System.out.println(noofQue + " noofque");


            TestIDAlreadyPresentDao taDao = new TestIDAlreadyPresentDao();
            if(taDao.alreadyPresent(testID)){
                
                request.setAttribute("errorMessage", "<div class=\"alert alert-danger\" role=\"alert\">\n" +
    "                    TestID already Created, Try another ID!\n" +
    "                  </div>");
                request.getRequestDispatcher("CreateTestID.jsp").forward(request, response);
            }

            else{
                System.out.println("table not already present");
                if(Pattern.matches("(?=.*[a-zA-Z])(?=\\S+$).{6}", testID))
                {
                    TestIDCreationDao dao = new TestIDCreationDao();
                    System.out.println("pattern matching");
                    if(dao.createTestID(testID)){
                        System.out.println("test id created");
                        HttpSession session = request.getSession();
                        session.setAttribute("testID", testID);
                        session.setAttribute("noofQue", noofQue);
                        
                        response.sendRedirect("AddQuestion.jsp");
                    }
                    else{
                        request.setAttribute("errorMessage", "<div class=\"alert alert-danger\" role=\"alert\">\n" +
        "                    Something went wrong, try again!\n" +
        "                  </div>");
                    request.getRequestDispatcher("CreateTestID.jsp").forward(request, response);
                    }
                }
                else{
                    request.setAttribute("errorMessage", "<div class=\"alert alert-danger\" role=\"alert\">\n" +
        "                    TestID must contain 6 digits with atleast one letter without any special Characters\n" +
        "                  </div>");
                    request.getRequestDispatcher("CreateTestID.jsp").forward(request, response);
                }
            }
        }
        catch(NumberFormatException e){
            request.setAttribute("errorMessage", "<div class=\"alert alert-danger\" role=\"alert\">\n" +
"                    No of Question must be a digit!\n" +
"                  </div>");
            request.getRequestDispatcher("CreateTestID.jsp").forward(request, response);

        }
    }

}
