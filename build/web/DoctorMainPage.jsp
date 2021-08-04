<%-- 
    Document   : DoctorMainPage
    Created on : May 25, 2021, 1:14:31 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
	String doctor_id = request.getParameter("doctor_id");
	String driver = "org.apache.derby.jdbc.EmbeddedDriver";

	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
        Statement statement1 = null;
	ResultSet resultSet1 = null;
        Statement statement2 = null;
	ResultSet resultSet2 = null;
%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel='stylesheet' href='DoctorMainPage.css'>
        <link rel='stylesheet' href='submitButton.css'>
    </head>
    
    <body>
        <div class="topnav">
            <form action="LogOut.jsp" method="post">
                <input class='btn1' type="submit" value="Log Out"></br></br></br>
            </form>
        </div>
        <div class="topnav">
            <h2 style="text-align: left">Doctor ID : <%= request.getParameter("doctor_id") %></br>
                <%
		try{
                    connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
                    statement=connection.createStatement();
                    String sql ="select * from DOCTOR_DETAILS where DOCTOR_ID='" + doctor_id + "'";
                    resultSet = statement.executeQuery(sql);
                    
                    while(resultSet.next()){%>
                        Doctor Name : Dr. <%=resultSet.getString("D_FNAME") %> <%=resultSet.getString("D_LNAME") %>
                    <%}
                    connection.close();
		} catch (Exception e) {
                    e.printStackTrace();
		}%>
            </h2>
            <form action="AddSchedule.jsp" method="post">
                <%session.setAttribute("doctor_id", doctor_id);%>
                <input class='btn4' type="submit" value="Add Schedule"></br></br></br>
            </form>
            <form action="DoctorDataEdit.jsp" method="post">
                <input class='btn4' type="submit" value="Edit Personal Data">
                <input type="hidden" name="doctor_id" value="<%= request.getParameter("doctor_id") %>">
            </form>
        </div>
        
            <%try{
                connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
                statement1=connection.createStatement();
                String sql1 ="select * from SCHEDULE where DOCTOR_ID='" + doctor_id + "'";
                resultSet1 = statement1.executeQuery(sql1);

                while(resultSet1.next()){%>
                    <div class="div">
                        <h2>Date : <%=resultSet1.getString("DATE") %></h2></br></br></br>
                         <h2 style="text-align: left">Session Start Time : <%=resultSet1.getString("START_TIME") %></br> 
                            Session End Time : <%=resultSet1.getString("END_TIME") %></br> 
                            No of Patient : <%=resultSet1.getString("N_O_P") %><br>
                        </h2>
                        <form action="EditSchedule.jsp" method="post">
                            <input type="hidden" name="doctor_id" value="<%= request.getParameter("doctor_id") %>">
                            <input type="hidden" name="date" value="<%=resultSet1.getString("DATE") %>">
                            <input class='btn1' type="submit" value="Edit Schedule Data"></br></br></br>
                        </form>
                            
                            
                        <form action="DeleteSchedule.jsp" method="post">
                            <input class='btn1' type="submit" value="Delete Schedule">
                            <input type="hidden" name="doctor_id" value="<%= request.getParameter("doctor_id") %>">
                            <input type="hidden" name="date" value="<%=resultSet1.getString("DATE") %>">
                        </form>
                            
                            
                    </div>
                <%}
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }%>
    </body>
</html>