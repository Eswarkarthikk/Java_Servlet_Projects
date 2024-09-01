<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h1>Show Student Data</h1>
    <table border="1">
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
            <td>${student.student_id}</td>
            <td>${student.name}</td>
            <td>${student.date_of_birth}</td>
            <td>${student.gender}</td>
            <td>${student.email}</td>
            <td>${student.phone_number}</td>
            <td>${student.address}</td>
            <td>${student.enrollment_date}</td>
            <td>${student.program_id}</td>
        </tr>
    </table>
</body>
</html>
