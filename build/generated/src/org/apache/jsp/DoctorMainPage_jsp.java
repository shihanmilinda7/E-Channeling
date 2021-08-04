package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public final class DoctorMainPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel='stylesheet' href='DoctorMainPage.css'>\n");
      out.write("        <link rel='stylesheet' href='submitButton.css'>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("       \n");
      out.write("        <div class=\"topnav\">\n");
      out.write("            <h2 style=\"text-align: left\">Doctor ID : ");
      out.print( request.getParameter("doctor_id") );
      out.write("</br>\n");
      out.write("                ");

		try{
                    connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
                    statement=connection.createStatement();
                    String sql ="select * from DOCTOR_DETAILS where DOCTOR_ID='" + doctor_id + "'";
                    resultSet = statement.executeQuery(sql);
                    
                    while(resultSet.next()){
      out.write("\n");
      out.write("                        Doctor Name : Dr. ");
      out.print(resultSet.getString("D_FNAME") );
      out.write(' ');
      out.print(resultSet.getString("D_LNAME") );
      out.write("\n");
      out.write("                    ");
}
                    connection.close();
		} catch (Exception e) {
                    e.printStackTrace();
		}
      out.write("\n");
      out.write("            </h2>\n");
      out.write("            <form action=\"AddSchedule.jsp\" method=\"post\">\n");
      out.write("                ");
session.setAttribute("doctor_id", doctor_id);
      out.write("\n");
      out.write("                <input class='btn4' type=\"submit\" value=\"Add Schedule\"></br></br></br>\n");
      out.write("            </form>\n");
      out.write("            <form action=\"DoctorDataEdit.jsp\" method=\"post\">\n");
      out.write("                <input class='btn4' type=\"submit\" value=\"Edit Personal Data\">\n");
      out.write("                <input type=\"hidden\" name=\"doctor_id\" value=\"");
      out.print( request.getParameter("doctor_id") );
      out.write("\">\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("            ");
try{
                connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
                statement1=connection.createStatement();
                String sql1 ="select * from SCHEDULE where DOCTOR_ID='" + doctor_id + "'";
                resultSet1 = statement1.executeQuery(sql1);

                while(resultSet1.next()){
      out.write("\n");
      out.write("                    <div class=\"div\">\n");
      out.write("                        <h2>Date : ");
      out.print(resultSet1.getString("DATE") );
      out.write("</h2></br></br></br>\n");
      out.write("                         <h2 style=\"text-align: left\">Session Start Time : ");
      out.print(resultSet1.getString("START_TIME") );
      out.write("</br> \n");
      out.write("                            Session End Time : ");
      out.print(resultSet1.getString("END_TIME") );
      out.write("</br> \n");
      out.write("                            No of Patient : ");
      out.print(resultSet1.getString("N_O_P") );
      out.write("<br>\n");
      out.write("                        </h2>\n");
      out.write("                        <form action=\"EditSchedule.jsp\" method=\"post\">\n");
      out.write("                            <input type=\"hidden\" name=\"doctor_id\" value=\"");
      out.print( request.getParameter("doctor_id") );
      out.write("\">\n");
      out.write("                            <input type=\"hidden\" name=\"date\" value=\"");
      out.print(resultSet1.getString("DATE") );
      out.write("\">\n");
      out.write("                            <input class='btn1' type=\"submit\" value=\"Edit Schedule Data\"></br></br></br>\n");
      out.write("                        </form>\n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                        <form action=\"DeleteSchedule.jsp\" method=\"post\">\n");
      out.write("                            <input class='btn1' type=\"submit\" value=\"Delete Schedule\">\n");
      out.write("                            <input type=\"hidden\" name=\"doctor_id\" value=\"");
      out.print( request.getParameter("doctor_id") );
      out.write("\">\n");
      out.write("                            <input type=\"hidden\" name=\"date\" value=\"");
      out.print(resultSet1.getString("DATE") );
      out.write("\">\n");
      out.write("                        </form>\n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                    </div>\n");
      out.write("                ");
}
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
