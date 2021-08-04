<%-- 
    Document   : PatientRecordsCheck
    Created on : May 26, 2021, 8:09:54 PM
    Author     : User
--%>

<%@page import="com.Util.RecordRegister"%>
<%@page import="com.Util.RecordValidate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel='stylesheet' href='alert.css'>
    </head>
    <jsp:useBean id="obj" class="com.Util.EnterRecord"/>  
    <jsp:setProperty property="*" name="obj"/>  
    <%
    String nic = request.getParameter("nic");
    String doctor_id = request.getParameter("doctor_id");
    String date = request.getParameter("date");
    //String ap_no = request.getParameter("p_count");
    
    boolean IsValid = RecordValidate.ValidateUser(nic,doctor_id,date); 
    if(IsValid){%>
    
        <div class="alert">
            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
            Appointment Failed.
        </div>
        <jsp:include page="PatientMainPage.jsp">
            <jsp:param name="patient_id" value="<%=nic%>" />            
        </jsp:include>
    <%}else{    
        int status = RecordRegister.register(obj);
        if(status>0){%>
            <div class="alert">
                <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
                Appointment Placed.
            </div>
            <jsp:include page="PatientMainPage.jsp">
                <jsp:param name="patient_id" value="<%=nic%>" />            
            </jsp:include>
        <%}%>
    <%}%>
</html>
