<%@ page import="java.sql.*, jakarta.servlet.http.HttpSession" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create or Update Details</title>
    <style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }

    .container {
        width: 50%;
        margin: 20px auto;
        padding: 20px;
        background-color: #fff;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        border-radius: 5px;
    }

    h1 {
        text-align: center;
        margin-bottom: 20px;
    }

    form {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    label {
        width: 50%;
        text-align: left;
        margin-bottom: 10px;
    }

    input[type="text"],
    input[type="date"],
    input[type="email"],
    select {
        width: 50%;
        padding: 8px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 3px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        width: 50%;
        padding: 10px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 3px;
        cursor: pointer;
        margin-top: 20px;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
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

        <jsp:include page="navigation.jsp" />
    <%
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
    %>
                <div class="container">
                    <h1>Create or Update Student Details</h1>
                    <form action="update" method="post">
                        <input type="hidden" name="rollNumber" value="<%= rollNumber %>" />
                        <label for="name">Name:</label>
                        <input type="text" id="name" name="name" value="<%= rs.getString("name") %>" required><br>
                        <label for="dateOfBirth">Date of Birth:</label>
                        <input type="date" id="dateOfBirth" name="dateOfBirth" value="<%= rs.getString("date_of_birth") %>" required><br>
                        <label for="gender">Gender:</label>
                        <select id="gender" name="gender" required>
                            <option value="Male" <%= rs.getString("gender").equals("Male") ? "selected" : "" %>>Male</option>
                            <option value="Female" <%= rs.getString("gender").equals("Female") ? "selected" : "" %>>Female</option>
                            <option value="Other" <%= rs.getString("gender").equals("Other") ? "selected" : "" %>>Other</option>
                        </select><br>
                        <label for="email">Email:</label>
                        <input type="email" id="email" name="email" value="<%= rs.getString("email") %>" required><br>
                        <label for="phoneNumber">Phone Number:</label>
                        <input type="text" id="phoneNumber" name="phoneNumber" value="<%= rs.getString("phone_number") %>" required><br>
                        <label for="address">Address:</label>
                        <input type="text" id="address" name="address" value="<%= rs.getString("address") %>" required><br>
                        <label for="enrollmentDate">Enrollment Date:</label>
                        <input type="date" id="enrollmentDate" name="enrollmentDate" value="<%= rs.getString("enrollment_date") %>" required><br>
      
                        <input type="submit" value="Submit">
                    </form>
                </div>
    <%
            } else {
                // Student is new, show create form
    %>
                <div class="container">
                    <h1>Create or Update Student Details</h1>
                    <form action="create" method="post">
                        <input type="hidden" name="rollNumber" value="<%= rollNumber %>" />
                        <label for="name">Name:</label>
                        <input type="text" id="name" name="name" required><br>
                        <label for="dateOfBirth">Date of Birth:</label>
                        <input type="date" id="dateOfBirth" name="dateOfBirth" required><br>
                        <label for="gender">Gender:</label>
                        <select id="gender" name="gender" required>
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                            <option value="Other">Other</option>
                        </select><br>
                        <label for="email">Email:</label>
                        <input type="email" id="email" name="email" required><br>
                        <label for="phoneNumber">Phone Number:</label>
                        <input type="text" id="phoneNumber" name="phoneNumber" required><br>
                        <label for="address">Address:</label>
                        <input type="text" id="address" name="address" required><br>
                        <label for="enrollmentDate">Enrollment Date:</label>
                        <input type="date" id="enrollmentDate" name="enrollmentDate" required><br>
                        <input type="submit" value="Submit">
                    </form>
                </div>
    <%
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
    %>
</body>
</html>
