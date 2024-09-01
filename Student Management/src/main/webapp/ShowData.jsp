<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*, jakarta.servlet.http.HttpSession, java.io.*, java.util.*" %>
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
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }

    .container {
        width: 80%;
        margin: 20px auto;
        padding: 20px;
        background-color: #fff;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    h1 {
        text-align: center;
        margin-bottom: 20px;
    }

    nav {
        text-align: center;
        margin-bottom: 20px;
    }

    nav a {
        display: inline-block;
        padding: 10px 20px;
        margin: 0 10px;
        color: #333;
        text-decoration: none;
        border-radius: 5px;
        background-color: #f0f0f0;
        transition: background-color 0.3s;
    }

    nav a:hover {
        background-color: #ddd;
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
</style>

</head>
<body>
    <div class="container">
    
        <jsp:include page="navigation.jsp" />
        <h1>Show Student Data</h1>
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
                <th>Program ID</th>
            </tr>
            <tr>
                <td><%= rs.getInt("student_id") %></td>
                <td><%= rs.getString("name") %></td>
                <td><%= rs.getDate("date_of_birth") %></td>
                <td><%= rs.getString("gender") %></td>
                <td><%= rs.getString("email") %></td>
                <td><%= rs.getString("phone_number") %></td>
                <td><%= rs.getString("address") %></td>
                <td><%= rs.getDate("enrollment_date") %></td>
                <td><%= rs.getInt("program_id") %></td>
            </tr>
        </table>
        <%
            } else {
        %>
        <p class="error">No student data found for roll number: <%= rollNumber %></p>
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
