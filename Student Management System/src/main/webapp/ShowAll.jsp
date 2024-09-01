<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*, jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Data</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }

    .container {
        width: 80%;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    h1 {
        text-align: center;
        margin-bottom: 20px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    th, td {
        padding: 8px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #f2f2f2;
    }

    .error {
        color: red;
        font-weight: bold;
    }
</style>
</head>
<body>
<div class="container">

        <jsp:include page="navigation.jsp" />
    <h1>All A/c Holders Data</h1>
    <%
        // Database connection and query
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/students";
            String USERNAME = "root";
            String PASSWORD = "";
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM student s LEFT JOIN program p ON s.program_id = p.program_id");
            ResultSet rs = ps.executeQuery();

            // Display student data
    %>
    <table>
        <tr>
            <th>Student ID</th>
            <th>Name</th>
            <th>Date of Birth</th>
            <th>Gender</th>
            <th>Email</th>
            <th>Phone Number</th>
            <th>Address</th>
            <th>Enrollment Date</th>
            
        </tr>
        <%
            while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("student_id") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getDate("date_of_birth") %></td>
            <td><%= rs.getString("gender") %></td>
            <td><%= rs.getString("email") %></td>
            <td><%= rs.getString("phone_number") %></td>
            <td><%= rs.getString("address") %></td>
            <td><%= rs.getDate("enrollment_date") %></td>
      
          
        </tr>
        <%
            }
        %>
    </table>
    <%
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
