<%-- 
    Document   : PatientDataEdit
    Created on : May 28, 2021, 4:01:44 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel='stylesheet' href='PatientDataEdit.css'>
    </head>
<body>

    <div>
        <form action="ValidateUpdateSchedule.jsp" method="post">
        <center>
            <h1>Update Schedule Details</h1></br>
            <h1><%= request.getParameter("date") %></h1></br>
            <label for="time">Starting Time</label></br>
            <div class="div">
                <input type="time" name="stime" placeholder="Starting Time.." class='dte'>
                <input type="hidden" name="doctor_id" value="<%= request.getParameter("doctor_id") %>">
                <input type="hidden" name="date" value="<%= request.getParameter("date") %>">
                <input type="submit" name="ufname" value="Update Starting Time" class='btn'></br>
            </div>
            
                <label for="time1">End Time</label></br>
            <div class="div">
                <input type="time" name="etime" placeholder="Ending Time.." class='dte'>
                <input type="hidden" name="doctor_id" value="<%= request.getParameter("doctor_id") %>">
                <input type="hidden" name="date" value="<%= request.getParameter("date") %>">
                <input type="submit" name="ufname" value="Update Ending Time" class='btn'></br>
            </div>
            
            <label for="time1">Number Of Patient</label></br>
            <div class="div">
                <input type="text" name="nop" placeholder="Number Of Patients.." class='dte'>
                <input type="hidden" name="doctor_id" value="<%= request.getParameter("doctor_id") %>">
                <input type="hidden" name="date" value="<%= request.getParameter("date") %>">
                <input type="submit" name="ufname" value="Update No Of Patient" class='btn'></br>
            </div>
                
        </center>
      </form>
    </div>


    </body>
</html>