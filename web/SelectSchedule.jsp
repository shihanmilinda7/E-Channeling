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
%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel='stylesheet' href='DoctorMainPage.css'>
        <link rel='stylesheet' href='submitButton.css'>
    </head>
    
    <body>
            <%try{
                connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
                statement1=connection.createStatement();
                String sql1 ="select * from SCHEDULE where DOCTOR_ID='" + doctor_id + "'";
                resultSet1 = statement1.executeQuery(sql1);%>

                <div class="div">
                        <h2> Dr. <%= request.getParameter("dfname") %> <%= request.getParameter("dlname") %></h2>
                </div>
                <%
                while(resultSet1.next()){%>
                <%-- comment/////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
                
                    <%try{
                        
                        statement=connection.createStatement();
                        String sql ="select (count(NIC)+1) from PATIENT_RECORDS where DOCTOR_ID='" + doctor_id + "' and DATE='"+ resultSet1.getString("DATE")+"'";
                        resultSet = statement.executeQuery(sql);%>
                        
                    <%} catch (Exception e) {
                        
                        e.printStackTrace();
                        
                    }%>
            
                <%-- comment/////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
                    <div class="div">
                        <h2 style="text-align:left">Date : <%=resultSet1.getString("DATE") %></br></br> 
                            Session Start Time : <%=resultSet1.getString("START_TIME") %> </br></br>
                            Session End Time : <%=resultSet1.getString("END_TIME") %> </br></br>
                            No of Patient : <%=resultSet1.getString("N_O_P") %></br></br>
                            
                            <%while(resultSet.next()){%>
                                Current Appointment No : <%=resultSet.getString(1) %> </h2></br></br>
                                <form action="ConfirmSchedule.jsp" method="post">
                                    <input type="hidden" name="dfname" value="<%= request.getParameter("dfname") %>">
                                    <input type="hidden" name="dlname" value="<%= request.getParameter("dlname") %>">
                                    <input type="hidden" name="doctor_id" value="<%=resultSet1.getString("DOCTOR_ID") %>">
                                    <input type="hidden" name="date" value="<%=resultSet1.getString("DATE") %>">
                                    <input type="hidden" name="p_count" value="<%=resultSet.getString(1) %>">
                                    <input type="hidden" name="patient_id" value="<%= request.getParameter("patient_id") %>"></br></br></br></br></br></br></br></br></br></br>
                                    <%int head_count = Integer.parseInt(resultSet1.getString("N_O_P"));
                                      int cur_count = Integer.parseInt(resultSet.getString(1));
                                      if(cur_count<=head_count){%>
                                        <input class='btn5' type="submit" value="Make Appointment">
                                      <%}else{%>
                                        <h2>Exceed.</h2>
                                      <%}%>
                                </form>
                            <%}%>
                       
                    </div>
                <%}
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }%>
    </body>
</html>