<%-- 
    Document   : CreateTestID
    Created on : May 30, 2021, 1:16:05 PM
    Author     : Shankari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IDCreation</title>
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
        margin-top: 130px;
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
            <form action="TestIDCreation" method="post">
                <div class="container" style=" background-color: rgb(227, 231, 220); border-radius: 7px; border-radius: 7px; padding-top: 70px; padding-left: 25px; padding-bottom: 40px; text-align: center; border-width: 100px; width: 500px; ">
                    <div class="textfield">
                         ${errorMessage} 
                        <p style="font-size: 24px; margin-right: 31px;">Create Test ID</p>
                        <input type="text" name="testID" required>
                        <br><br><br>
                        <p style="font-size: 23px; margin-left: 50px;">Enter No of Questions</p>
                        <input type="text" name="noofQuestions" required>
                        <br><br>
                        <button type="submit" class="btn btn-primary">Create</button>
                    </div>
                    <br>
                </div>
            </form>
        </div>
    </div>

    

    <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</body>
</html>