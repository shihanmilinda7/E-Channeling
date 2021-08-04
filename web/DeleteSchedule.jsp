
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel='stylesheet' href='alert.css'>
    </head>
    <body>
        <%
            String doctor_id = request.getParameter("doctor_id");
            String date = request.getParameter("date");
            Connection conn = null;
            PreparedStatement pst = null;
            try{

                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                conn = DriverManager.getConnection ("jdbc:derby://localhost:1527/sample","app","app");
                pst = conn.prepareStatement("delete from SCHEDULE where DOCTOR_ID=? and DATE=?");
                pst.setString(1,doctor_id);
                pst.setString(2,date);

                pst.executeUpdate();
              }catch(Exception e){
                System.out.print(e.getMessage());
            }finally{
                pst.close();
                conn.close();
            }
        %>

        <div class="alert">
            <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
            <%=doctor_id%> <%=date%>
        </div>
        <jsp:include page="DoctorMainPage.jsp">
            <jsp:param name="doctor_id" value="<%=doctor_id%>" />            
        </jsp:include>
    </body>
</html>
