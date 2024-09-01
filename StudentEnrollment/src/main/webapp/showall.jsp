<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.sql.*, jakarta.servlet.http.HttpSession,test.StudentModel" %>
<html>
<head>
    <title>All Enrollments</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 5px;
        }
    </style>
</head>
<body>
    <h1>All Enrollments</h1>

    <%-- Execute query and retrieve all enrollments --%>
    <%
    Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            try {
                connection = StudentModel.getConnection();
                String query = "SELECT * FROM StudentCourse"; // Assuming all enrollments are retrieved
                statement = connection.prepareStatement(query);
                resultSet = statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace(); // Handle database exceptions (log or display error message)
                out.print("An error occurred while retrieving enrollment data."); // Display error message for user
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

    <%-- Display enrollment data if found --%>
    <% if (resultSet != null) { %>
        <table>
            <tr>
                <th>Roll Number</th>
                <th>Course ID</th>
                <th>Course Name</th>
                <th>Enrollment Date</th>
                <th>Email</th>
                <th>Phone</th>
            </tr>
            <c:forEach var="enrollment" items="${resultSet}">  <tr>
                    <td><c:out value="${enrollment.student_roll_number}" default="-"/></td>
                    <td><c:out value="${enrollment.course_id}" /></td>
                    <td><c:out value="${enrollment.course_name}" default="-"/></td>
                    <td><c:out value="${enrollment.enrollment_date}" /></td>
                    <td><c:out value="${enrollment.email}" default="-"/></td>
                    <td><c:out value="${enrollment.phone}" default="-"/></td>
                </tr>
            </c:forEach>
        </table>
    <% } else { %>
        <p>No enrollment data found.</p>
    <% } %>
</body>
</html>
