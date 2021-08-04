<%-- 
    Document   : PatientDataEdit
    Created on : May 28, 2021, 6:21:19 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel='stylesheet' href='PatientDataEdit.css'>
    </head>
<body>

    <div>
      <form action="ValidateEditPatientData.jsp">
        <center>
            <h1>Update Your Details</h1></br>
			<div class="div">
				<input type="text" name="fname" placeholder="Your First Name With First Letter Capital ( Ex - Alex ).." class='dte'>
                                <input type="hidden" name="patient_id" value="<%= request.getParameter("patient_id") %>">
				<input type="submit" name="ufname" value="Update First Name" class='btn'></br>
			</div>
            
                        <div class="div">
				<input type="text" name="lname" placeholder="Your Last Name With First Letter Capital ( Ex - Nick ).." class='dte'>
				<input type="hidden" name="patient_id" value="<%= request.getParameter("patient_id") %>">
				<input type="submit" name="ufname" value="Update Last Name" class='btn'></br>
			</div>
                       
			<div class="div">
				<input type="text" name="mobile" placeholder="Phone(Mobile).." class='dte'>
				<input type="hidden" name="patient_id" value="<%= request.getParameter("patient_id") %>">
				<input type="submit" name="ufname" value="Update Mobile Number" class='btn'></br>
			</div>
            
			<div class="div">
				<input type="password" name="password1" placeholder="Enter Your New Password.." class='dte'></br>
				<input type="password" name="password2" placeholder="Confirm Your New Password Again.." class='dte'>
				<input type="hidden" name="patient_id" value="<%= request.getParameter("patient_id") %>">
				<input type="submit" name="ufname" value="Update Password" class='btn'></br>
			</div>
        </center>
      </form>
    </div>


    </body>
</html>
