

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel='stylesheet' href='alert.css'>
    </head>
    <div class="alert">
        <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
        Logout Successfully.
    </div>
    <%
        session.invalidate();
        response.sendRedirect("SelectLogin.jsp");%>
</html>