package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public final class SelectDoctor_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel='stylesheet' href='DoctorMainPage.css'>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>        \n");
      out.write("        ");
try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            statement=connection.createStatement();
            String sql ="select D_FNAME,D_LNAME,DOCTOR_ID from DOCTOR_DETAILS where SPECIALIZATION='" + spc + "'";
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
      out.write("\n");
      out.write("                <div class=\"div\">\n");
      out.write("                    <h2>Dr. ");
      out.print(resultSet.getString("D_FNAME") );
      out.write(" \n");
      out.write("                        ");
      out.print(resultSet.getString("D_LNAME") );
      out.write(" \n");
      out.write("                    </h2>\n");
      out.write("                    <div>\n");
      out.write("                        <form action=\"SelectSchedule.jsp\" method=\"post\">\n");
      out.write("                            <input type=\"hidden\" name=\"doctor_id\" id=\"doctor_id\" value=\"");
      out.print(resultSet.getString("DOCTOR_ID") );
      out.write("\"></br>\n");
      out.write("                            <input type=\"hidden\" name=\"dfname\" id=\"doctor_id\" value=\"");
      out.print(resultSet.getString("D_FNAME") );
      out.write("\"></br>\n");
      out.write("                            <input type=\"hidden\" name=\"dlanme\" id=\"doctor_id\" value=\"");
      out.print(resultSet.getString("D_LNAME") );
      out.write("\"></br>\n");
      out.write("                            <input class='btn' type=\"submit\" value=\"Make Appointment\">\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            ");
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
