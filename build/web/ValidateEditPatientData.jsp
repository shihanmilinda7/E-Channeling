<%@page import="java.lang.String"%>
<%@page import="com.Util.UpdatePatient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel='stylesheet' href='alert.css'>
    </head>
    <jsp:useBean id="obj" class="com.Util.PatientDataUpdate"/>  
    <jsp:setProperty property="*" name="obj"/>  
    <%String nic = request.getParameter("patient_id");
    String password1 = request.getParameter("password1");
    String password2 = request.getParameter("password2");
    
    int status = UpdatePatient.update(obj);
    int status1 = UpdatePatient.updatePassword(obj);
    if(status>0){%>
        <div class="alert">
            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
            Updated.
        </div>
        <jsp:include page="PatientDataEdit.jsp">
            <jsp:param name="patient_id" value="<%=nic%>" />            
        </jsp:include>
    <%}%>
    <%if(password1.equals(password2)){
        if(status1>0){%>
        <div class="alert">
            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
            Updated.
        </div>
        <jsp:include page="PatientDataEdit.jsp">
            <jsp:param name="patient_id" value="<%=nic%>" />            
        </jsp:include>
        <%}%>
    <%}else{%>
        <div class="alert">
            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
            Password Not Matched.
        </div>
        <jsp:include page="PatientDataEdit.jsp">
            <jsp:param name="patient_id" value="<%=nic%>" />            
        </jsp:include>
    <%}%>
</html>