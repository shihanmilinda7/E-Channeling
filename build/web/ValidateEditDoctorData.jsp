<%@page import="java.lang.String"%>
<%@page import="com.Util.UpdateDoctor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel='stylesheet' href='alert.css'>
    </head>
    <jsp:useBean id="obj" class="com.Util.DoctorDataUpdate"/>  
    <jsp:setProperty property="*" name="obj"/>  
    <%String doctor_id = request.getParameter("doctor_id");
    String password1 = request.getParameter("password1");
    String password2 = request.getParameter("password2");
    
    int status = UpdateDoctor.update(obj);
    int status1 = UpdateDoctor.updatePassword(obj);
    if(status>0){%>
        <div class="alert">
            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
            Updated.
        </div>
        <jsp:include page="DoctorDataEdit.jsp">
            <jsp:param name="doctor_id" value="<%=doctor_id%>" />            
        </jsp:include>
    <%}%>
    <%if(password1.equals(password2)){
        if(status1>0){%>
        <div class="alert">
            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
            Updated.
        </div>
        <jsp:include page="DoctorDataEdit.jsp">
            <jsp:param name="doctor_id" value="<%=doctor_id%>" />            
        </jsp:include>
        <%}%>
    <%}else{%>
        <div class="alert">
            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
            Password Not Matched.
        </div>
        <jsp:include page="DoctorDataEdit.jsp">
            <jsp:param name="doctor_id" value="<%=doctor_id%>" />            
        </jsp:include>
    <%}%>
</html>