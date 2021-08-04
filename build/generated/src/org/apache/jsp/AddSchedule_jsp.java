package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AddSchedule_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel='stylesheet' href='PatientRegister.css'>\n");
      out.write("    </head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <div>\n");
      out.write("        ");
String doctor_id = session.getAttribute("doctor_id").toString(); 
      out.write("\n");
      out.write("        <form action=\"ScheduleCheck.jsp\" method=\"post\">\n");
      out.write("        <center>\n");
      out.write("            <h1>Add Schedule</h1></br>\n");
      out.write("            \n");
      out.write("            <h3>Doctor ID : ");
      out.print( doctor_id);
      out.write("</h3>\n");
      out.write("            \n");
      out.write("            <label for=\"date\">Date</label></br>\n");
      out.write("            <input type=\"date\" name=\"date\" placeholder=\"Enter Date..\" class='dte'></br>\n");
      out.write("            \n");
      out.write("            <label for=\"time\">Starting Time</label></br>\n");
      out.write("            <input type=\"time\" name=\"time\" placeholder=\"Start Time..\" class='dte'></br>\n");
      out.write("            \n");
      out.write("            <label for=\"time1\">End Time</label></br>\n");
      out.write("            <input type=\"time\" name=\"time1\" placeholder=\"End Time..\" class='dte'></br>\n");
      out.write("\n");
      out.write("            <label for=\"time1\">Number Of Patient</label></br>\n");
      out.write("            <input type=\"text\" name=\"noofpatient\" placeholder=\"Number Of Patient..\" class='dte'></br>\n");
      out.write("            \n");
      out.write("            <input type=\"hidden\" name=\"doctor_id1\" id=\"doctor_id1\" value=\"");
      out.print( doctor_id);
      out.write("\"></br>\n");
      out.write("            \n");
      out.write("            <input type=\"submit\" value=\"Submit\" class='btn'></br>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </center>\n");
      out.write("      </form>\n");
      out.write("    </div>\n");
      out.write("\n");
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
