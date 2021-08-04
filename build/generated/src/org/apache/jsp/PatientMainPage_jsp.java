package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public final class PatientMainPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel='stylesheet' href='PatientRegister.css'>\n");
      out.write("    </head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"div\">\n");
      out.write("         <h2 style=\"text-align: left\">\n");
      out.write("            ");

            try{
                connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
                statement=connection.createStatement();
                String sql ="select * from PATIENTDETAILS where NIC='" + patient_id + "'";
                resultSet = statement.executeQuery(sql);

                while(resultSet.next()){
      out.write("\n");
      out.write("                    Name : ");
      out.print(resultSet.getString("FNAME") );
      out.write(' ');
      out.print(resultSet.getString("LNAME") );
      out.write("\n");
      out.write("                ");
}
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
      out.write("\n");
      out.write("         </h2>\n");
      out.write("        <form action=\"PatientDataEdit.jsp\" method=\"post\">\n");
      out.write("            <input type=\"hidden\" name=\"patient_id\" value=\"");
      out.print( request.getParameter("patient_id") );
      out.write("\">\n");
      out.write("            <input type=\"submit\" value=\"Edit Personal Data\" class='btn1'>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("    <div>\n");
      out.write("        <form action=\"SelectDoctor.jsp\" method=\"post\">\n");
      out.write("        <center>\n");
      out.write("            \n");
      out.write("            <h1>Make An Appointment</h1></br>    \n");
      out.write("            <select id=\"specialization\" name=\"specialization\" class=\"dte\">\n");
      out.write("                ");

		try{
                    connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
                    statement=connection.createStatement();
                    String sql ="select distinct SPECIALIZATION from DOCTOR_DETAILS";
                    resultSet = statement.executeQuery(sql);
                    
                    while(resultSet.next()){
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(resultSet.getString("SPECIALIZATION") );
      out.write("\" class=\"dte\">");
      out.print(resultSet.getString("SPECIALIZATION") );
      out.write("</option>\n");
      out.write("                    ");
}
                    connection.close();
		} catch (Exception e) {
                    e.printStackTrace();
		}
      out.write("\n");
      out.write("            </select></br>\n");
      out.write("            <input type=\"hidden\" name=\"patient_id\" value=\"");
      out.print( request.getParameter("patient_id") );
      out.write("\"></br>\n");
      out.write("            <input type=\"submit\" value=\"Submit\" class='btn'></br>        \n");
      out.write("        </center>\n");
      out.write("      </form>\n");
      out.write("    </div>\n");
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
