<%-- 
    Document   : PatientRegister
    Created on : May 24, 2021, 1:43:49 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
	String patient_id = request.getParameter("patient_id");
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
        Statement statement4 = null;
	ResultSet resultSet4 = null;
%>
<!DOCTYPE html>
<html>
    <head>
        <link rel='stylesheet' href='PatientRegister.css'>
    </head>
<body>
    <div class="div">
         <h2 style="text-align: left">
            <%
            try{
                connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
                statement=connection.createStatement();
                String sql ="select * from PATIENTDETAILS where NIC='" + patient_id + "'";
                resultSet = statement.executeQuery(sql);

                while(resultSet.next()){%>
                    Name : <%=resultSet.getString("FNAME") %> <%=resultSet.getString("LNAME") %>
                <%}
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }%>
         </h2>
         <form action="LogOut.jsp" method="post">
            <input class='btn1' type="submit" value="Log Out">
        </form>
        <form action="PatientDataEdit.jsp" method="post">
            <input type="hidden" name="patient_id" value="<%= request.getParameter("patient_id") %>">
            <input type="submit" value="Edit Personal Data" class='btn1'>
        </form>
    </div>
    <div>
        <form action="SelectDoctor.jsp" method="post">
        <center>
            
            <h1>Make An Appointment</h1></br>    
            <select id="specialization" name="specialization" class="dte">
                <%
		try{
                    connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
                    statement=connection.createStatement();
                    String sql ="select distinct SPECIALIZATION from DOCTOR_DETAILS";
                    resultSet = statement.executeQuery(sql);
                    
                    while(resultSet.next()){%>
                    <option value="<%=resultSet.getString("SPECIALIZATION") %>" class="dte"><%=resultSet.getString("SPECIALIZATION") %></option>
                    <%}
                    connection.close();
		} catch (Exception e) {
                    e.printStackTrace();
		}%>
            </select></br>
            <input type="hidden" name="patient_id" value="<%= request.getParameter("patient_id") %>"></br>
            <input type="submit" value="Submit" class='btn'></br>        
        </center>
      </form>
    </div>
            
     <%
    try{
        connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
        statement1=connection.createStatement();
        String sql1 ="select * from PATIENT_RECORDS where NIC='" + request.getParameter("patient_id") + "'";
        resultSet1 = statement1.executeQuery(sql1);

        while(resultSet1.next()){%>
            <%
            try{
                connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
                statement2=connection.createStatement();
                String sql2 ="select * from DOCTOR_DETAILS where DOCTOR_ID='" + resultSet1.getString("DOCTOR_ID") + "'";
                resultSet2 = statement2.executeQuery(sql2);

                while(resultSet2.next()){%>
                
                    <%
                    try{
                        connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
                        statement4=connection.createStatement();
                        String sql4 ="select * from SCHEDULE where DOCTOR_ID='" + resultSet1.getString("DOCTOR_ID") + "' and DATE='"+ resultSet1.getString("DATE")+"'";
                        resultSet4 = statement4.executeQuery(sql4);

                        while(resultSet4.next()){%>
                            <div class="div">
                                <h2 style="text-align: left">Doctor Name : Dr. <%=resultSet2.getString("D_FNAME") %> <%=resultSet2.getString("D_LNAME") %></br>
                                Date : <%=resultSet1.getString("DATE") %></br>
                                Start Time : <%=resultSet4.getString("START_TIME") %></br>
                                End Time : <%=resultSet4.getString("END_TIME") %></br>
                                Appointment Number : <%=resultSet1.getString("AP_NO") %></br>
                                </h2>
                            </div> 
                        <%}

                    } catch (Exception e) {
                        e.printStackTrace();
                    }%>
                <%}
            } catch (Exception e) {
                e.printStackTrace();
            }%>
        <%}
        
    connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }%>
    </body>
</html>