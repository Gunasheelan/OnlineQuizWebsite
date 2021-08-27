<%-- 
    Document   : Index
    Created on : May 30, 2021, 12:48:22 PM
    Author     : Shankari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Index</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<style>
    * {
      box-sizing: border-box;
    }
    
    .flex-container {
      display: flex;
      flex-direction: row;
    }
    
    .flex-item-left {
        margin-top: 120px;
        margin-left: 30px;
      flex: 50%;
    }
    
    .flex-item-right {
        margin-top: 130px;
        margin-left: 30px;
        margin-bottom: 30px;
      flex: 50%;
    }
    
    @media (max-width: 800px) {
      .flex-container {
        flex-direction: column;
      }
    }
    </style>
<body>

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
<!--              <form action="">
                <button type="submit" class="btn btn-link" style="text-decoration: none;"><p style="margin-top: 5px; margin-right: 5px">Logout</p></button>
              </form>-->
            </ul>
          </div>
        </div>
      </nav>

    <div class="flex-container">
            <div class="flex-item-left">
                <div class="container well"  style="width: 500px; border-radius: 6px; padding: 20px;">
                    <form action="ValidAdmin" method="post">
                        ${errorMessageAdmin} 
                       <p class="h3"> <i class="glyphicon glyphicon-user" style="font-size: 19px; padding-right: 5px;"></i> Login for Admin</p>
                       <br>
                       Username: <input type="text" name="userName" placeholder="Enter your Username" required style="margin-left: 12px;">
                       <br><br>
                       Password: <input type="password" name="passWord" placeholder="Enter your Password" required style="margin-left: 14px;">
                       <br><br>
                       <button type="submit" class="btn btn-success">Login</button>
                       <br><br>
                    </form>
                       <form action="ForgotPasswordAdmin.jsp" method="post">
                           <button type="submit" class="btn-link" style="padding-left: 1px;">Forgot Password?</button>
                       </form>
                       <form action="SignupAdmin.jsp" method="post">
                         <div class="container2" style="padding-left: 1px;">
                             Not a member?
                         <button type="submit" class="btn btn-link" style="padding-left: 1px;">Signup</button>
                         </div>
                        </form>
        
                </div>
            </div>
            <div class="flex-item-right">
                <div class="container well"  style="width: 500px; border-radius: 6px; padding: 20px;">
                    <form action="ValidStudent" method="post">
                        ${errorMessageStudent} 
                       <p class="h3"> <i class="glyphicon glyphicon-user" style="font-size: 19px; padding-right: 5px;"></i> Login for Student</p>
                       <br>
                       Username: <input type="text" name="userName" placeholder="Enter your Username" required style="margin-left: 25px;">
                       <br><br>
                       Roll Number: <input type="text" name="rollNo" placeholder="Enter your Roll No" required style="margin-left: 12px;">
                       <br><br>
                       Password: <input type="password" name="passWord" placeholder="Enter your Password" required style="margin-left: 27px;">
                       <br><br>
                       <button type="submit" class="btn btn-success">Login</button>
                       <br><br>
                    </form>
                       <form action="ForgotPasswordStudent.jsp" method="post">
                           <button type="submit" class="btn-link" style="padding-left: 1px;">Forgot Password?</button>
                       </form>
                       <form action="SignupStudent.jsp" method="post">
                         <div class="container2" style="padding-left: 1px;">
                             Not a member?
                         <button type="submit" class="btn btn-link" style="padding-left: 1px;">Signup</button>
                         </div>
                       </form>
        
                </div>
          </div>
    </div>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</body>
</html>

