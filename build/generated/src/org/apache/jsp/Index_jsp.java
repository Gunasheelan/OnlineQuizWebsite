package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Index</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\" integrity=\"sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu\" crossorigin=\"anonymous\">\n");
      out.write("</head>\n");
      out.write("<style>\n");
      out.write("    * {\n");
      out.write("      box-sizing: border-box;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    .flex-container {\n");
      out.write("      display: flex;\n");
      out.write("      flex-direction: row;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    .flex-item-left {\n");
      out.write("        margin-top: 120px;\n");
      out.write("        margin-left: 30px;\n");
      out.write("      flex: 50%;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    .flex-item-right {\n");
      out.write("        margin-top: 130px;\n");
      out.write("        margin-left: 30px;\n");
      out.write("        margin-bottom: 30px;\n");
      out.write("      flex: 50%;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    @media (max-width: 800px) {\n");
      out.write("      .flex-container {\n");
      out.write("        flex-direction: column;\n");
      out.write("      }\n");
      out.write("    }\n");
      out.write("    </style>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <nav class=\"navbar navbar-inverse navbar-fixed-top\">\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("          <div class=\"navbar-header\">\n");
      out.write("            <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\n");
      out.write("              <span class=\"icon-bar\"></span>\n");
      out.write("              <span class=\"icon-bar\"></span>\n");
      out.write("              <span class=\"icon-bar\"></span>\n");
      out.write("            </button>\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">OnlineMCQ</a>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("            <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("<!--              <form action=\"\">\n");
      out.write("                <button type=\"submit\" class=\"btn btn-link\" style=\"text-decoration: none;\"><p style=\"margin-top: 5px; margin-right: 5px\">Logout</p></button>\n");
      out.write("              </form>-->\n");
      out.write("            </ul>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </nav>\n");
      out.write("\n");
      out.write("    <div class=\"flex-container\">\n");
      out.write("            <div class=\"flex-item-left\">\n");
      out.write("                <div class=\"container well\"  style=\"width: 500px; border-radius: 6px; padding: 20px;\">\n");
      out.write("                    <form action=\"ValidAdmin\" method=\"post\">\n");
      out.write("                        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errorMessageAdmin}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" \n");
      out.write("                       <p class=\"h3\"> <i class=\"glyphicon glyphicon-user\" style=\"font-size: 19px; padding-right: 5px;\"></i> Login for Admin</p>\n");
      out.write("                       <br>\n");
      out.write("                       Username: <input type=\"text\" name=\"userName\" placeholder=\"Enter your Username\" required style=\"margin-left: 12px;\">\n");
      out.write("                       <br><br>\n");
      out.write("                       Password: <input type=\"password\" name=\"passWord\" placeholder=\"Enter your Password\" required style=\"margin-left: 14px;\">\n");
      out.write("                       <br><br>\n");
      out.write("                       <button type=\"submit\" class=\"btn btn-success\">Login</button>\n");
      out.write("                       <br><br>\n");
      out.write("                    </form>\n");
      out.write("                       <form action=\"ForgotPasswordAdmin.jsp\" method=\"post\">\n");
      out.write("                           <button type=\"submit\" class=\"btn-link\" style=\"padding-left: 1px;\">Forgot Password?</button>\n");
      out.write("                       </form>\n");
      out.write("                       <form action=\"SignupAdmin.jsp\" method=\"post\">\n");
      out.write("                         <div class=\"container2\" style=\"padding-left: 1px;\">\n");
      out.write("                             Not a member?\n");
      out.write("                         <button type=\"submit\" class=\"btn btn-link\" style=\"padding-left: 1px;\">Signup</button>\n");
      out.write("                         </div>\n");
      out.write("                        </form>\n");
      out.write("        \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"flex-item-right\">\n");
      out.write("                <div class=\"container well\"  style=\"width: 500px; border-radius: 6px; padding: 20px;\">\n");
      out.write("                    <form action=\"ValidStudent\" method=\"post\">\n");
      out.write("                        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errorMessageStudent}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" \n");
      out.write("                       <p class=\"h3\"> <i class=\"glyphicon glyphicon-user\" style=\"font-size: 19px; padding-right: 5px;\"></i> Login for Student</p>\n");
      out.write("                       <br>\n");
      out.write("                       Username: <input type=\"text\" name=\"userName\" placeholder=\"Enter your Username\" required style=\"margin-left: 25px;\">\n");
      out.write("                       <br><br>\n");
      out.write("                       Roll Number: <input type=\"text\" name=\"rollNo\" placeholder=\"Enter your Roll No\" required style=\"margin-left: 12px;\">\n");
      out.write("                       <br><br>\n");
      out.write("                       Password: <input type=\"password\" name=\"passWord\" placeholder=\"Enter your Password\" required style=\"margin-left: 27px;\">\n");
      out.write("                       <br><br>\n");
      out.write("                       <button type=\"submit\" class=\"btn btn-success\">Login</button>\n");
      out.write("                       <br><br>\n");
      out.write("                    </form>\n");
      out.write("                       <form action=\"ForgotPasswordStudent.jsp\" method=\"post\">\n");
      out.write("                           <button type=\"submit\" class=\"btn-link\" style=\"padding-left: 1px;\">Forgot Password?</button>\n");
      out.write("                       </form>\n");
      out.write("                       <form action=\"SignupStudent.jsp\" method=\"post\">\n");
      out.write("                         <div class=\"container2\" style=\"padding-left: 1px;\">\n");
      out.write("                             Not a member?\n");
      out.write("                         <button type=\"submit\" class=\"btn btn-link\" style=\"padding-left: 1px;\">Signup</button>\n");
      out.write("                         </div>\n");
      out.write("                       </form>\n");
      out.write("        \n");
      out.write("                </div>\n");
      out.write("          </div>\n");
      out.write("    </div>\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-1.12.4.min.js\" integrity=\"sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <!-- Include all compiled plugins (below), or include individual files as needed -->\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\" integrity=\"sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd\" crossorigin=\"anonymous\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
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
