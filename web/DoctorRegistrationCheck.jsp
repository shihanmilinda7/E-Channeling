


<%@page import="com.Util.DoctorRegister"%>
<%@page import="com.Util.RealDoctorValidation"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="com.Util.ValidateDoctorRegistration"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel='stylesheet' href='alert.css'>
    </head>
    <jsp:useBean id="obj" class="com.Util.EnterDoctorDetails"/>  
    <jsp:setProperty property="*" name="obj"/>  
    
    <%
    String doctor_id = request.getParameter("doctorId");
    String fname = request.getParameter("fname");
    String password1 = request.getParameter("password1");
    String password2 = request.getParameter("password2");
    
    boolean IsValid = ValidateDoctorRegistration.ValidateUser(doctor_id);
    boolean IsValid1 = RealDoctorValidation.ValidateUser1(doctor_id, fname);
    
    if(IsValid1){
        if(password1.equals(password2)){
            if(IsValid){%>
                <div class="alert">
                    <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                    Already registered.
                </div>
                <jsp:include page="DoctorRegister.jsp"/>
            <%}else{%>
                <% int status = DoctorRegister.register(obj);
                if(status>0){%>
                    <div class="alert">
                        <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                        registered.
                    </div>
                    <jsp:include page="DoctorLogin.jsp"/>
                <%}%>
            <%}%>
        <%}else{%>
            <div class="alert">
                <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                Password not match.
            </div>
            <jsp:include page="DoctorRegister.jsp"/>
        <%}%>
    <%}else{%>
        <div class="alert">
            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
            Your Doctor ID is not Valid. Please Enter Valid Doctor ID.
        </div>
        <jsp:include page="DoctorRegister.jsp"/>
    <%}%>    
</html>
