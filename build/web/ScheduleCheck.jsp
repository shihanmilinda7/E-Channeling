<%-- 
    Document   : ScheduleCheck
    Created on : May 25, 2021, 3:00:00 PM
    Author     : User
--%>

<%@page import="com.Util.ScheduleRegister"%>
<%@page import="com.Util.ScheduleValidate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel='stylesheet' href='alert.css'>
    </head>
    <jsp:useBean id="obj" class="com.Util.EnterSchedule"/>  
    <jsp:setProperty property="*" name="obj"/>  
    <%
    String doctor_id = session.getAttribute("doctor_id").toString();
    String date = request.getParameter("date");
    boolean IsValid = ScheduleValidate.ValidateUser(doctor_id, date);
    //ResultSet rs = getUserData.func(semail, spassword); 
    if(IsValid){%>
        <div class="alert">
            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
            Fail.
        </div> 
        <jsp:include page="AddSchedule.jsp"/>
    <%}else{%>
        <% int status = ScheduleRegister.register(obj);
        if(status>0){%>
            <div class="alert">
                <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                registered.
            </div>
            <jsp:include page="AddSchedule.jsp"/>
        <%}%>
    <%}%>
</html>


