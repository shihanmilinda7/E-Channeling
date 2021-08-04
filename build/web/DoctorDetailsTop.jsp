<%-- 
    Document   : DoctorDetailsTop
    Created on : May 30, 2021, 4:44:35 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
    String driver = "org.apache.derby.jdbc.EmbeddedDriver";

    try {
            Class.forName(driver);
    } catch (ClassNotFoundException e) {
            e.printStackTrace();
    }
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='DoctorMainPage.css'>
    </head>
    <body>
        <%try{
                connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
                statement=connection.createStatement();
                String sql1 ="select * from DOCTOR_DETAILS";
                resultSet = statement.executeQuery(sql1);

                while(resultSet.next()){%>
                    <div class="div">
                        <h2>Dr. <%=resultSet.getString("D_FNAME") %> <%=resultSet.getString("D_lNAME") %></h2></br></br></br>
                         <h2 style="text-align: left"><%=resultSet.getString("SPECIALIZATION") %></br> 
                            Mobile No : <%=resultSet.getString("MOBILE_NUMBER") %></br> 
                        </h2>
                    </div>
                <%}
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }%>
    </body>
</html>
