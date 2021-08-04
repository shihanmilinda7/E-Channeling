package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ConfirmSchedule_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	String doctor_id = request.getParameter("doctor_id");
        String patient_id = request.getParameter("patient_id");
        String dfname = request.getParameter("dfname");
        String dlname = request.getParameter("dlname");
        String date = request.getParameter("date");
        String p_count= request.getParameter("p_count");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel='stylesheet' href='DoctorMainPage.css'>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"div\">\n");
      out.write("            <h2 style=\"text-align: left\">\n");
      out.write("                Patient NIC : ");
      out.print(patient_id);
      out.write("</br>\n");
      out.write("                Doctor Name : Dr. ");
      out.print(dfname);
      out.write(' ');
      out.print(dlname);
      out.write("</br>\n");
      out.write("                Appointment Date : ");
      out.print(date);
      out.write("</br>\n");
      out.write("                Appointment Number : ");
      out.print(p_count);
      out.write("</h2></br>\n");
      out.write("                <form action=\"PatientRecordsCheck.jsp\" method=\"post\">\n");
      out.write("                    <input type=\"hidden\" name=\"nic\" value=\"");
      out.print(patient_id);
      out.write("\"></br>\n");
      out.write("                    <input type=\"hidden\" name=\"doctor_id\" value=\"");
      out.print(doctor_id);
      out.write("\"></br>\n");
      out.write("                    <input type=\"hidden\" name=\"date\" value=\"");
      out.print(date);
      out.write("\"></br>\n");
      out.write("                    <input type=\"hidden\" name=\"p_count\" value=\"");
      out.print(p_count);
      out.write("\"></br>\n");
      out.write("                    <input class='btn' type=\"submit\" value=\"Confirm Appointment\">\n");
      out.write("                </form>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
