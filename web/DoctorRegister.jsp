<%-- 
    Document   : PatientRegister
    Created on : May 24, 2021, 1:43:49 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel='stylesheet' href='PatientRegister.css'>
    </head>
<body>

    <div>
      <form action="DoctorRegistrationCheck.jsp">
        <center>
            <h1>Doctor Register Form</h1></br>
            <input type="text" name="fname" placeholder="Your First Name With First Letter Capital ( Ex - Alex ).." class='dte'></br>

            <input type="text" name="lname" placeholder="Your Last Name.." class='dte'></br>

            <input type="text" name="doctorId" placeholder="Doctor ID.." class='dte'></br>
            
             <input type="text" name="specialization" placeholder="Specialization.." class='dte'></br>

            <input type="text" name="mobile" placeholder="Phone(Mobile).." class='dte'></br>

            <input type="password" name="password1" placeholder="Enter Your password.." class='dte'></br>

            <input type="password" name="password2" placeholder="Confirm Your password again.." class='dte'></br>
            
            <input type="submit" value="Submit" class='btn'></br>
            
            
        </center>
      </form>
    </div>


    </body>
</html>