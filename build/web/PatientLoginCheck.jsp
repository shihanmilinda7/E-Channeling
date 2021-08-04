<%-- 
    Document   : PatientLoginCheak
    Created on : May 24, 2021, 8:28:54 PM
    Author     : User
--%>

<%@page import="com.Util.PatientLoginValidate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel='stylesheet' href='alert.css'>
    </head>
    <%
        String nic = request.getParameter("nic");
        String password = request.getParameter("password");
        boolean IsValid = PatientLoginValidate.ValidateUser(nic, password);
        //ResultSet rs = getUserData.func(semail, spassword); 
        if(IsValid){%>
            <div class="alert">
                <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                Login Success.
            </div>
            
            <jsp:include page="PatientMainPage.jsp">
                    <jsp:param name="patient_id" value="<%=nic%>" />            
            </jsp:include>
            
        <%}else{%>
            <div class="alert">
                <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                Login Fail.
            </div>
            <jsp:include page="PatientLogin.jsp"/>
        <%}%>
</html>