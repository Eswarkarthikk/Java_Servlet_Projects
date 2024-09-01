/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.19
 * Generated at: 2024-04-20 07:34:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.sql.*;
import jakarta.servlet.http.HttpSession;

public final class CreateorUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(1);
    _jspx_imports_classes.add("jakarta.servlet.http.HttpSession");
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Create or Update Student Details</title>\r\n");
      out.write("    <style>\r\n");
      out.write("    body {\r\n");
      out.write("        font-family: Arial, sans-serif;\r\n");
      out.write("        margin: 0;\r\n");
      out.write("        padding: 0;\r\n");
      out.write("        background-color: #f4f4f4;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .container {\r\n");
      out.write("        width: 50%;\r\n");
      out.write("        margin: 20px auto;\r\n");
      out.write("        padding: 20px;\r\n");
      out.write("        background-color: #fff;\r\n");
      out.write("        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\r\n");
      out.write("        border-radius: 5px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    h1 {\r\n");
      out.write("        text-align: center;\r\n");
      out.write("        margin-bottom: 20px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    form {\r\n");
      out.write("        display: flex;\r\n");
      out.write("        flex-direction: column;\r\n");
      out.write("        align-items: center;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    label {\r\n");
      out.write("        width: 50%;\r\n");
      out.write("        text-align: left;\r\n");
      out.write("        margin-bottom: 10px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    input[type=\"text\"],\r\n");
      out.write("    input[type=\"date\"],\r\n");
      out.write("    input[type=\"email\"],\r\n");
      out.write("    select {\r\n");
      out.write("        width: 50%;\r\n");
      out.write("        padding: 8px;\r\n");
      out.write("        margin-bottom: 10px;\r\n");
      out.write("        border: 1px solid #ccc;\r\n");
      out.write("        border-radius: 3px;\r\n");
      out.write("        box-sizing: border-box;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    input[type=\"submit\"] {\r\n");
      out.write("        width: 50%;\r\n");
      out.write("        padding: 10px;\r\n");
      out.write("        background-color: #4CAF50;\r\n");
      out.write("        color: white;\r\n");
      out.write("        border: none;\r\n");
      out.write("        border-radius: 3px;\r\n");
      out.write("        cursor: pointer;\r\n");
      out.write("        margin-top: 20px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    input[type=\"submit\"]:hover {\r\n");
      out.write("        background-color: #45a049;\r\n");
      out.write("    }\r\n");
      out.write("    </style>\r\n");
      out.write("    <style>\r\n");
      out.write("    body {\r\n");
      out.write("        font-family: Arial, sans-serif;\r\n");
      out.write("        margin: 0;\r\n");
      out.write("        padding: 0;\r\n");
      out.write("        background-color: #f4f4f4;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .container {\r\n");
      out.write("        width: 80%;\r\n");
      out.write("        margin: 20px auto;\r\n");
      out.write("        padding: 20px;\r\n");
      out.write("        background-color: #fff;\r\n");
      out.write("        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    h1 {\r\n");
      out.write("        text-align: center;\r\n");
      out.write("        margin-bottom: 20px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    nav {\r\n");
      out.write("        text-align: center;\r\n");
      out.write("        margin-bottom: 20px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    nav a {\r\n");
      out.write("        display: inline-block;\r\n");
      out.write("        padding: 10px 20px;\r\n");
      out.write("        margin: 0 10px;\r\n");
      out.write("        color: #333;\r\n");
      out.write("        text-decoration: none;\r\n");
      out.write("        border-radius: 5px;\r\n");
      out.write("        background-color: #f0f0f0;\r\n");
      out.write("        transition: background-color 0.3s;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    nav a:hover {\r\n");
      out.write("        background-color: #ddd;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    table {\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        border-collapse: collapse;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    th, td {\r\n");
      out.write("        padding: 8px;\r\n");
      out.write("        text-align: left;\r\n");
      out.write("        border-bottom: 1px solid #ddd;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    th {\r\n");
      out.write("        background-color: #f2f2f2;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("    \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "navigation.jsp", out, false);
      out.write("\r\n");
      out.write("    ");

        HttpSession Session = request.getSession();
        String rollNumber = (String) session.getAttribute("rollNumber");
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "");
            ps = conn.prepareStatement("SELECT * FROM student WHERE RollNumber = ?");
            ps.setString(1, rollNumber);
            rs = ps.executeQuery();
            if (rs.next()) {
                // Student exists, show update form
    
      out.write("\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <h1>Create or Update Student Details</h1>\r\n");
      out.write("                    <form action=\"update\" method=\"post\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"rollNumber\" value=\"");
      out.print( rollNumber );
      out.write("\" />\r\n");
      out.write("                        <label for=\"name\">Name:</label>\r\n");
      out.write("                        <input type=\"text\" id=\"name\" name=\"name\" value=\"");
      out.print( rs.getString("name") );
      out.write("\" required><br>\r\n");
      out.write("                        <label for=\"dateOfBirth\">Date of Birth:</label>\r\n");
      out.write("                        <input type=\"date\" id=\"dateOfBirth\" name=\"dateOfBirth\" value=\"");
      out.print( rs.getString("date_of_birth") );
      out.write("\" required><br>\r\n");
      out.write("                        <label for=\"gender\">Gender:</label>\r\n");
      out.write("                        <select id=\"gender\" name=\"gender\" required>\r\n");
      out.write("                            <option value=\"Male\" ");
      out.print( rs.getString("gender").equals("Male") ? "selected" : "" );
      out.write(">Male</option>\r\n");
      out.write("                            <option value=\"Female\" ");
      out.print( rs.getString("gender").equals("Female") ? "selected" : "" );
      out.write(">Female</option>\r\n");
      out.write("                            <option value=\"Other\" ");
      out.print( rs.getString("gender").equals("Other") ? "selected" : "" );
      out.write(">Other</option>\r\n");
      out.write("                        </select><br>\r\n");
      out.write("                        <label for=\"email\">Email:</label>\r\n");
      out.write("                        <input type=\"email\" id=\"email\" name=\"email\" value=\"");
      out.print( rs.getString("email") );
      out.write("\" required><br>\r\n");
      out.write("                        <label for=\"phoneNumber\">Phone Number:</label>\r\n");
      out.write("                        <input type=\"text\" id=\"phoneNumber\" name=\"phoneNumber\" value=\"");
      out.print( rs.getString("phone_number") );
      out.write("\" required><br>\r\n");
      out.write("                        <label for=\"address\">Address:</label>\r\n");
      out.write("                        <input type=\"text\" id=\"address\" name=\"address\" value=\"");
      out.print( rs.getString("address") );
      out.write("\" required><br>\r\n");
      out.write("                        <label for=\"enrollmentDate\">Enrollment Date:</label>\r\n");
      out.write("                        <input type=\"date\" id=\"enrollmentDate\" name=\"enrollmentDate\" value=\"");
      out.print( rs.getString("enrollment_date") );
      out.write("\" required><br>\r\n");
      out.write("      \r\n");
      out.write("                        <input type=\"submit\" value=\"Submit\">\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("    ");

            } else {
                // Student is new, show create form
    
      out.write("\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <h1>Create or Update Student Details</h1>\r\n");
      out.write("                    <form action=\"create\" method=\"post\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"rollNumber\" value=\"");
      out.print( rollNumber );
      out.write("\" />\r\n");
      out.write("                        <label for=\"name\">Name:</label>\r\n");
      out.write("                        <input type=\"text\" id=\"name\" name=\"name\" required><br>\r\n");
      out.write("                        <label for=\"dateOfBirth\">Date of Birth:</label>\r\n");
      out.write("                        <input type=\"date\" id=\"dateOfBirth\" name=\"dateOfBirth\" required><br>\r\n");
      out.write("                        <label for=\"gender\">Gender:</label>\r\n");
      out.write("                        <select id=\"gender\" name=\"gender\" required>\r\n");
      out.write("                            <option value=\"Male\">Male</option>\r\n");
      out.write("                            <option value=\"Female\">Female</option>\r\n");
      out.write("                            <option value=\"Other\">Other</option>\r\n");
      out.write("                        </select><br>\r\n");
      out.write("                        <label for=\"email\">Email:</label>\r\n");
      out.write("                        <input type=\"email\" id=\"email\" name=\"email\" required><br>\r\n");
      out.write("                        <label for=\"phoneNumber\">Phone Number:</label>\r\n");
      out.write("                        <input type=\"text\" id=\"phoneNumber\" name=\"phoneNumber\" required><br>\r\n");
      out.write("                        <label for=\"address\">Address:</label>\r\n");
      out.write("                        <input type=\"text\" id=\"address\" name=\"address\" required><br>\r\n");
      out.write("                        <label for=\"enrollmentDate\">Enrollment Date:</label>\r\n");
      out.write("                        <input type=\"date\" id=\"enrollmentDate\" name=\"enrollmentDate\" required><br>\r\n");
      out.write("                        <input type=\"submit\" value=\"Submit\">\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("    ");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
