<%-- 
    Document   : TestPageStudent
    Created on : Jun 1, 2021, 1:55:41 PM
    Author     : Shankari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "jakarta.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TestPage</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<style>
    * {
      box-sizing: border-box;
    }
    
    .flex-container {
      display: flex;
      flex-direction: column;
    }


    .flex-item-left {
        margin-left: 150px;
        margin-right: 150px;
      flex: 50%;
    }
    .flex-item-right {
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
<!--    <form action="TestIDCreation" method="post">-->
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
              <form action="LogoutStudent" method="post">
                <button type="submit" class="btn btn-link" style="text-decoration: none;"><p style="margin-top: 5px; margin-right: 5px">Logout</p></button>
              </form>
            </ul>
          </div>
        </div>
      </nav>
<% try { %> 
    <div class="container2" style="margin-top: 90px; text-align: center;">
        <p class="h4">TestID : ${sessionScope.testID} 
        <br><br> No of Questions: ${sessionScope.noofQue} </p>
    </div>
    <div class="flex-container">
            <form action="MiddleStudent" method="post">
                    <div class="flex-item-left well">
                    <p class="h4"> <%
                        int num = Integer.parseInt(session.getAttribute("queNo").toString());
                        session.setAttribute("num", num); %> ${sessionScope.queNo}. ${sessionScope.question}  </p>
                      <br><br>
                      <input type="radio" name="option" value="${sessionScope.option1}" style="margin-right: 10px;"> ${sessionScope.option1}
                      <br><br>
                      <input type="radio" name="option" value="${sessionScope.option2}" style="margin-right: 10px;"> ${sessionScope.option2}
                      <br><br>
                      <input type="radio" name="option" value="${sessionScope.option3}" style="margin-right: 10px;"> ${sessionScope.option3}
                      <br><br>
                      <input type="radio" name="option" value="${sessionScope.option4}" style="margin-right: 10px;"> ${sessionScope.option4}
                      <br><br>
                    
                </div>
        
                <div class="flex-item-right" style="margin-left: 150px;">
                    <button type="submit" class="btn btn-primary" >Next</button>
                </div>
            </form>
    </div>
 <% } 
catch(NullPointerException e){

out.println("Something went wrong!");
}%> 
    <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</body>
</html>