<%-- 
    Document   : ConfirmSchedule
    Created on : May 26, 2021, 6:26:14 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
	String doctor_id = request.getParameter("doctor_id");
        String patient_id = request.getParameter("patient_id");
        String dfname = request.getParameter("dfname");
        String dlname = request.getParameter("dlname");
        String date = request.getParameter("date");
        String p_count= request.getParameter("p_count");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel='stylesheet' href='DoctorMainPage.css'>
    </head>
    <body>
        <div class="div">
            <h2 style="text-align: left">
                Patient NIC : <%=patient_id%></br>
                Doctor Name : Dr. <%=dfname%> <%=dlname%></br>
                Appointment Date : <%=date%></br>
                Appointment Number : <%=p_count%></h2>
                <form action="PatientRecordsCheck.jsp" method="post">
                    <input type="hidden" name="nic" value="<%=patient_id%>"></br>
                    <input type="hidden" name="doctor_id" value="<%=doctor_id%>"></br>
                    <input type="hidden" name="date" value="<%=date%>"></br>
                    <input type="hidden" name="p_count" value="<%=p_count%>"></br>
                    <input class='btn' type="submit" value="Confirm Appointment">
                </form>
        </div>
    </body>
</html>
