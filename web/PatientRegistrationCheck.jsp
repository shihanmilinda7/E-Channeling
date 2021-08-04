


<%@page import="com.Util.PatientRegister"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="com.Util.ValidatePatientRegistration"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel='stylesheet' href='alert.css'>
    </head>
    <jsp:useBean id="obj" class="com.Util.EnterPatientDetails"/>  
    <jsp:setProperty property="*" name="obj"/>  
    
    <%
    String nic = request.getParameter("nic");
    String password1 = request.getParameter("password1");
    String password2 = request.getParameter("password2");
    boolean IsValid = ValidatePatientRegistration.ValidateUser(nic);
    
    if(password1.equals(password2)){
        if(IsValid){%>
            <div class="alert">
                <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                Already registered.
            </div>
            <jsp:include page="PatientRegister.jsp"/>
        <%}else{%>
            <% int status = PatientRegister.register(obj);
            if(status>0){%>
                <div class="alert">
                    <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                    registered.
                </div>
                <jsp:include page="PatientLogin.jsp"/>
            <%}%>
        <%}%>
    <%}else{%>
        <div class="alert">
            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
            Password not match.
        </div>
        <jsp:include page="PatientRegister.jsp"/>
    <%}%> 
</html>
