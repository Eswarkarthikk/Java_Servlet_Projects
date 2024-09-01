<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*, jakarta.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <style>


       .contain{
        max-width: 600px;
            padding: 20px;
            justify-content:center;
            align-items:center;
       }

        .welcome-message {
            font-size: 36px;
            margin-bottom: 20px;
        }

        .message {
            font-size: 24px;
            text-align: justify;
            margin: 0 auto;
        }
    </style>
</head>
<body>

        <jsp:include page="navigation.jsp" />
         <center>  
<div class="contain">      
   <p class="welcome-message">Welcome back</p>

    <%
        // Retrieve roll number from session
        HttpSession Session = request.getSession();
        String rollNumber = (String) session.getAttribute("rollNumber");

        // Database connection and query
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/students";
            String USERNAME = "root";
            String PASSWORD = "";
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM student WHERE RollNumber = ?");
            ps.setString(1, rollNumber);
            ResultSet rs = ps.executeQuery();

            // Display student data
            if (rs.next()) {
                if(rs.getString("name").equals("null")) {
    %>
                    <p class="message">Your data is missing. Please update your details.</p>
    <%
                } else {
    %>
                    <%= rs.getString("name") %>
    <%
                }
            } else {
    %>
               <p class="message">You are a new account holder. Please enter your details in createorupdate form.</p> <!-- No student data found -->
    <%
            }

            // Close resources
            rs.close();
            ps.close();
            conn.close();
        } catch (ClassNotFoundException e) {
    %>
            <p class="error">Error loading MySQL JDBC driver: <%= e.getMessage() %></p>
    <%
        } catch (SQLException e) {
    %>
            <p class="error">SQL Error: <%= e.getMessage() %></p>
    <%
        }
    %>
      </div>
</body>
</html>
