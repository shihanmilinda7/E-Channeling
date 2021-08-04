<%-- 
    Document   : DoctorLoginCheck
    Created on : May 24, 2021, 8:49:26 PM
    Author     : User
--%>

<%@page import="com.Util.DoctorLoginValidate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel='stylesheet' href='alert.css'>
    </head>
    <%
    String doctor_id = request.getParameter("doctorId");
    String password = request.getParameter("password");
    boolean IsValid = DoctorLoginValidate.ValidateUser(doctor_id, password);
    //ResultSet rs = getUserData.func(semail, spassword); 
    if(IsValid){%>
        <div class="alert">
            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
            Login Success.
        </div>

        <jsp:include page="DoctorMainPage.jsp">
            <jsp:param name="doctor_id" value="<%=doctor_id%>" />            
        </jsp:include>
    
    <%}else{%>
        <div class="alert">
            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
            Login Fail.
        </div>
        <jsp:include page="DoctorLogin.jsp"/>
    <%}%>
</html>