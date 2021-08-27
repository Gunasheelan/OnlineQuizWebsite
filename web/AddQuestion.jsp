<%-- 
    Document   : AddQuestion
    Created on : May 30, 2021, 2:37:16 PM
    Author     : Shankari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "com.login.servlet.QueUpdation" %>
<%@page import = "jakarta.servlet.http.HttpSession" %>
<%@page import = "java.sql.*" %>
<%@page import = "com.login.Dao.QueUpdationDao" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AddQuestion</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<style>
    * {
      box-sizing: border-box;
    }
    
    .flex-container {
      /* margin-top: 100px; */
      display: flex;
      flex-direction: row;
    }
    
    .flex-item-left {
        margin-top: 80px;
        margin-left: 30px;
        margin-bottom: 40px;
      flex: 50%;
    }
    
    @media (max-width: 800px) {
      .flex-container {
        flex-direction: column;
      }
    }
    </style>
<body>
     <%
         response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        if(session.getAttribute("userName") == null)
        {
            response.sendRedirect("Index.jsp");
        }
        %>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
              <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">OnlineMCQ</a>
              </div>
              <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav navbar-right">
                  <form action="LogoutAdmin" method="post">
                    <button type="submit" class="btn btn-link" style="text-decoration: none;"><p style="margin-top: 5px; margin-right: 5px">Logout</p></button>
                  </form>
                </ul>
              </div>
            </div>
          </nav>
        <div class="flex-container">
            <div class="flex-item-left">
                <form action="QueUpdation" method="post">
                    <div class="container" style=" border-radius: 7px; border-radius: 7px; background-color: rgb(227, 231, 220); padding-top: 70px; padding-left: 25px; padding-bottom: 100px; text-align: center; border-width: 100px; width: 500px; ">
                        <div class="textfield">
                            <p style="font-size: 23px;">Add Questions</p>
                            <br>
               
                            <p style="font-size: 20px; margin-right: 355px;">Question
                                 <% String testID = session.getAttribute("testID").toString();
                                    QueUpdationDao dao2 = new QueUpdationDao();
                int row = dao2.rowCount(testID);
                out.println(row + 1); %> 
                            </p>
                            <textarea name="question" id="" cols="60" rows="5" required></textarea>
                            <br><br>
                            <label>Option 1</label>
                            <input type="text" name="option1" required>
                            <br><br>
                            <label>Option 2</label>
                            <input type="text" name="option2" required>
                            <br><br>
                            <label>Option 3</label>
                            <input type="text" name="option3" required>
                            <br><br>
                            <label>Option 4</label>
                            <input type="text" name="option4" required>
                            <br><br>
                            <label>Correct Answer</label>
                            <input type="text" name="correctAnswer" required style="margin-right: 50px;">
                            <br><br>
                            <button type="submit" class="btn btn-primary">Add</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

    

    <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</body>
</html>


