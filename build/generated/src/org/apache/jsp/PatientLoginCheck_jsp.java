package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.Util.PatientLoginValidate;

public final class PatientLoginCheck_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel='stylesheet' href='alert.css'>\n");
      out.write("    </head>\n");
      out.write("    ");

    String nic = request.getParameter("nic");
    String password = request.getParameter("password");
    boolean IsValid = PatientLoginValidate.ValidateUser(nic, password);
    //ResultSet rs = getUserData.func(semail, spassword); 
    if(IsValid){
      out.write("\n");
      out.write("    <div class=\"alert\">\n");
      out.write("        <span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>\n");
      out.write("        Login Success.\n");
      out.write("    </div>\n");
      out.write("    ");
      if (true) {
        _jspx_page_context.forward("PatientMainPage.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("patient_id", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(nic), request.getCharacterEncoding()));
        return;
      }
      out.write("\n");
      out.write("    ");
}else{
      out.write("\n");
      out.write("    <div class=\"alert\">\n");
      out.write("        <span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>\n");
      out.write("        Login Fail.\n");
      out.write("    </div>\n");
      out.write("    ");
}
      out.write("\n");
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
