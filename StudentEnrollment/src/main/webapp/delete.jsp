<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Confirm Enrollment Deletion</title>
</head>
<body>
    <h1>Confirm Enrollment Deletion</h1>

    <%
        // Get roll number from session (assuming it's available)
        String rollNumber = (String) session.getAttribute("rollNumber");
    %>

    <p>Are you sure you want to delete the enrollment for roll number: <%= rollNumber %>?</p>

    <form action="delete" method="post">
        <input type="hidden" name="rollNumber" value="<%= rollNumber %>">
        <button type="submit">Delete</button>
    </form>

</body>
</html>
