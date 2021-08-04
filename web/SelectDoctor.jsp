<%-- 
    Document   : SelectDoctor
    Created on : May 25, 2021, 9:51:25 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
	String spc = request.getParameter("specialization");
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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel='stylesheet' href='DoctorMainPage.css'>
    </head>
    
    <body>        
        <%try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            statement=connection.createStatement();
            String sql ="select D_FNAME,D_LNAME,DOCTOR_ID from DOCTOR_DETAILS where SPECIALIZATION='" + spc + "'";
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){%>
                <div class="div">
                    <h2>Dr. <%=resultSet.getString("D_FNAME") %> 
                        <%=resultSet.getString("D_LNAME") %> 
                    </h2>
                    <div>
                        <form action="SelectSchedule.jsp" method="post">
                            <input type="hidden" name="doctor_id" id="doctor_id" value="<%=resultSet.getString("DOCTOR_ID") %>"></br>
                            <input type="hidden" name="dfname" id="doctor_id" value="<%=resultSet.getString("D_FNAME") %>"></br>
                            <input type="hidden" name="dlname" id="doctor_id" value="<%=resultSet.getString("D_LNAME") %>"></br>
                            <input type="hidden" name="patient_id" value="<%= request.getParameter("patient_id") %>"></br>
                            <input class='btn' type="submit" value="Make Appointment">
                        </form>
                    </div>
                </div>
            <%}
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }%>
    </body>
</html>