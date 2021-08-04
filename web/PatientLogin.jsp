<%-- 
    Document   : PatientLogin
    Created on : May 24, 2021, 1:17:49 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>login</title>
        <link rel='stylesheet' href='PatientLogin.css'>
        <meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    </head>
    <body>
        <div class='login-box'>
            <h1>Login</h1>
            <form action='PatientLoginCheck.jsp'>
                <div class='textbox'>
                    <i class="fas fa-user"></i>
                    <input type='text' placeholder='NIC' name='nic' value=''>
                </div>

                <div class='textbox'>
                    <i class="fas fa-lock"></i>
                    <input type='password' placeholder='Password' name='password' value=''>
                </div>

                <input class='btn' type='submit' value='Login'>
            </form>
            <center>
                <a href='PatientRegister.jsp'>If you don't have an account? Create Account </a>
            </center>
        </div>
    </body>
</html>