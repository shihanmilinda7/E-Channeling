<%@page import="java.lang.String"%>
<%@page import="com.Util.UpdateSchedule"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel='stylesheet' href='alert.css'>
    </head>
    <jsp:useBean id="obj" class="com.Util.EditScheduleData"/>  
    <jsp:setProperty property="*" name="obj"/>  
    <%String nic = request.getParameter("doctor_id");

    int status = UpdateSchedule.update(obj);
    
    if(status>0){%>
        <div class="alert">
            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
            Updated.
        </div>
        <jsp:include page="EditSchedule.jsp">
            <jsp:param name="doctor_id" value="<%=nic%>" />            
        </jsp:include>
    <%}%>
</html>