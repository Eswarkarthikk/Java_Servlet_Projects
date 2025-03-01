/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.19
 * Generated at: 2024-04-20 06:30:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import test.ServiceModel;

public final class success_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/navigation.jsp", Long.valueOf(1713593995426L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(1);
    _jspx_imports_classes.add("test.ServiceModel");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("  \r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("  .message {\r\n");
      out.write("    padding: 10px 20px;\r\n");
      out.write("    margin-bottom: 20px;\r\n");
      out.write("    border: 1px solid #ddd;\r\n");
      out.write("    border-radius: 5px;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .message.info {\r\n");
      out.write("    background-color: #f0f9ff;\r\n");
      out.write("    color: #333;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .message.warning {\r\n");
      out.write("    background-color: #ffecec;\r\n");
      out.write("    color: #8a6f6f;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .button-container {\r\n");
      out.write("    text-align: center;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .button {\r\n");
      out.write("    padding: 10px 20px;\r\n");
      out.write("    background-color: #4CAF50;\r\n");
      out.write("    color: white;\r\n");
      out.write("    border: none;\r\n");
      out.write("    border-radius: 3px;\r\n");
      out.write("    cursor: pointer;\r\n");
      out.write("    transition: background-color 0.2s ease-in-out;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .button:hover {\r\n");
      out.write("    background-color: #3e8e41;\r\n");
      out.write("  }\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

  String rollNumber = (String) session.getAttribute("rollNumber");
String password = (String) session.getAttribute("password");
  boolean hasData = ServiceModel.validateUser(rollNumber,password); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("body {\r\n");
      out.write("    margin: 0;\r\n");
      out.write("    font-family: Arial, sans-serif;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav {\r\n");
      out.write("    background-color: white;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    padding: 10px 0;\r\n");
      out.write("    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav a, nav .current-service, nav button {\r\n");
      out.write("    display: inline-block;\r\n");
      out.write("    color: black;\r\n");
      out.write("    background-color: #f0f0f0; /* Off-white background color */\r\n");
      out.write("    border: 2px solid #f0f0f0; /* Match background color */\r\n");
      out.write("    border-radius: 5px;\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("    padding: 10px 20px;\r\n");
      out.write("    margin: 0 10px;\r\n");
      out.write("    font-size: 14px;\r\n");
      out.write("    transition: background-color 0.3s ease, color 0.3s ease, border-color 0.3s ease;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav a:hover, nav .current-service:hover, nav button:hover {\r\n");
      out.write("    background-color: #007bff; /* Blue color on hover */\r\n");
      out.write("    color: white; /* White text on hover */\r\n");
      out.write("    border-color: #007bff; /* Match background color on hover */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form1 {\r\n");
      out.write("    display: inline-block;\r\n");
      out.write("    vertical-align: middle;\r\n");
      out.write("    margin-right: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </style>\r\n");
      out.write("\r\n");
      out.write("    <nav>\r\n");
      out.write("        <a class=\"student\">current service ID: ");
      out.print( session.getAttribute("rollNumber") );
      out.write("</a>\r\n");
      out.write("        <a href=\"add.jsp\">Add Service</a>\r\n");
      out.write("        <a href=\"update.jsp\">Update</a>\r\n");
      out.write("        <a href=\"delete.jsp\">Delete</a>\r\n");
      out.write("        <a href=\"show.jsp\">Show All Details</a>\r\n");
      out.write("        <form class=\"form1\" action=\"logout\" method=\"post\">\r\n");
      out.write("            <button type=\"submit\" style=\"background-color:red\">Logout</button>\r\n");
      out.write("        </form>\r\n");
      out.write("    </nav>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\"><center>\r\n");
      out.write("  <div class=\"message ");
 if (hasData) { 
      out.write("info");
 } else { 
      out.write("warning");
 } 
      out.write("\">\r\n");
      out.write("    ");
 if (hasData) { 
      out.write("\r\n");
      out.write("      \r\n");
      out.write("  <h1>Welcome back, ");
      out.print( rollNumber );
      out.write("!</h1>\r\n");
      out.write("      please go to services to view your services \r\n");
      out.write("    ");
 } else { 
      out.write("\r\n");
      out.write("      welcome to the service management system \r\n");
      out.write("      please go to services to add or update  your services \r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
