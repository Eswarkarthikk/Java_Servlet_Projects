<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, jakarta.servlet.http.HttpSession,test.StudentModel" %>

<!DOCTYPE html>
<html>
<head>
    <title>Your Enrollment Details</title>
</head>
<body>
    <h1>Your Enrollment Details</h1>

    <%-- Check if roll number is available in session --%>
    <%
    if (session.getAttribute("rollNumber") != null) {
    %>
        <p>Roll Number: <%=session.getAttribute("rollNumber")%></p>

        <%-- Execute query and retrieve enrollment data --%>
        <%
        String rollNumber = (String) session.getAttribute("rollNumber");
                    Connection connection = null;
                    PreparedStatement statement = null;
                    ResultSet resultSet = null;
                    try {
                        connection = StudentModel.getConnection();
                        String query = "SELECT * FROM StudentCourse WHERE student_roll_number = ?";
                        statement = connection.prepareStatement(query);
                        statement.setString(1, rollNumber);
                        resultSet = statement.executeQuery();
                        
                        if (resultSet.next()) {
        %>
                    <table border="1">
                        <tr>
                            <th>Course ID</th>
                            <th>Course Name</th>
                            <th>Enrollment Date</th>
                            <th>Email</th>
                            <th>Phone</th>
                        </tr>
                        <tr>
                            <td><%= resultSet.getInt("course_id") %></td>
                            <td><%= resultSet.getString("course_name") %></td>
                            <td><%= resultSet.getDate("enrollment_date") %></td>
                            <td><%= resultSet.getString("email") %></td>
                            <td><%= resultSet.getString("phone") %></td>
                        </tr>
                    </table>
                    <% 
                } else {
                    %>
                    <p>No enrollment data found for this roll number.</p>
                    <%
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Handle database exceptions (log or display error message)
            } finally {
                // Close resources (connection, statement, result set)
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace(); // Handle exceptions while closing result set
                    }
                }
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace(); // Handle exceptions while closing statement
                    }
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace(); // Handle exceptions while closing connection
                    }
                }
            }
        %>
    <% } else { %>
        <p>Error: Roll number not found in session.</p>
    <% } %>
</body>
</html>
