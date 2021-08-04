<%-- 
    Document   : AddSchedule
    Created on : May 25, 2021, 1:30:30 PM
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
        <%String doctor_id = session.getAttribute("doctor_id").toString(); %>
        <form action="ScheduleCheck.jsp" method="post">
        <center>
            <h1>Add Schedule</h1></br>
            
            <h3>Doctor ID : <%= doctor_id%></h3>
            
            <label for="date">Date</label></br>
            <input type="date" name="date" placeholder="Enter Date.." class='dte'></br>
            
            <label for="time">Starting Time</label></br>
            <input type="time" name="time" placeholder="Start Time.." class='dte'></br>
            
            <label for="time1">End Time</label></br>
            <input type="time" name="time1" placeholder="End Time.." class='dte'></br>

            <label for="time1">Number Of Patient</label></br>
            <input type="text" name="noofpatient" placeholder="Number Of Patient.." class='dte'></br>
            
            <input type="hidden" name="doctor_id1" id="doctor_id1" value="<%= doctor_id%>"></br>
            
            <input type="submit" value="Submit" class='btn'></br>
            
            
        </center>
      </form>
    </div>


    </body>
</html>