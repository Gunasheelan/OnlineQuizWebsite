<%-- 
    Document   : ForgotPasswordAdmin
    Created on : May 30, 2021, 11:22:30 PM
    Author     : Shankari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ForgotPassword</title>
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
    
    @media (max-width: 1000px) {
      .flex-container {
        flex-direction: column;
      }
    }
    </style>
<body">
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
            <div class="container well" style="width: 500px;">
                 ${errorMessage} 
                        <form action="ForgotPasswordAdmin" method="post">
                            <h3>ForgotPassword for Admin</h3>
                            <br>
                        <div class="textfield">
                            Username:
                            <input type="text" name="userName" placeholder="Enter existing Username" required style="margin-left: 47px;">
                            <br><br><br>
                        </div>
                        <div class="textfield">
                            Create Password:
                            <input type="password" name="passWord" placeholder="Create new Password" required style="margin-left: 5px;">
                            <br><br><br>
                        </div>
                        <div class="textfield">
                            Confirm Password:
                            <input type="password" name="confirmpassWord" placeholder="Retype new Password" required>
                            <br><br><br>
                        </div>
                        <button type="submit" class="btn btn-success">Login</button>
                        <br><br>
                    </form>
            </div>
        </div>
    </div>

    

    <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</body>
</html>

