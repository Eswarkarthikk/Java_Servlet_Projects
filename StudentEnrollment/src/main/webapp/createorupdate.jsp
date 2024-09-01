<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.sql.*, jakarta.servlet.http.HttpSession,test.StudentModel" %>

<%
// Get user's roll number from session (assuming checkSession.jsp sets it)
  String rollNumber = (String) session.getAttribute("rollNumber");

  // Existing enrollment data (assuming direct query execution)
  String studentName = "";
  String email = "";
  String phone = "";
  int courseId = 0;
  String courseName = "";
  String enrollmentDate = "";

  try {
      Connection connection = StudentModel.getConnection(); // Assuming getConnection is static
      String query = "SELECT * FROM StudentCourse WHERE student_roll_number = ?";
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setString(1, rollNumber);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
          studentName = resultSet.getString("student_name");
          email = resultSet.getString("email");
          phone = resultSet.getString("phone");
          courseId = resultSet.getInt("course_id");
          courseName = resultSet.getString("course_name");
          enrollmentDate = resultSet.getString("enrollment_date");
      }
      resultSet.close();
      statement.close();
      connection.close();
  } catch (SQLException e) {
      e.printStackTrace();
      // Handle potential SQLException (e.g., display error message)
  }
%>

<!DOCTYPE html>
<html>
<head>
  <title>Create/Update Course Details</title>
  <style>
  /* Basic styles */
body {
  font-family: sans-serif;
  margin: 20px;
}

h1 {
  text-align: center;
  margin-bottom: 20px;
}

.container {
  border: 1px solid #ddd;
  padding: 20px;
  border-radius: 5px;
  width: 500px;
  margin: 0 auto;  /* Center the form horizontally */
}

label {
  display: block;
  margin-bottom: 5px;
}

input[type="text"],
input[type="email"],
input[type="number"] {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

input[type="submit"] {
  background-color: #4CAF50;  /* Green */
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-top: 15px;
}

input[type="submit"]:hover {
  background-color: #45a049;
}

/* Styling for readonly enrollment date field */
#enrollmentDate {
  background-color: #eee;
}
  
  </style>
</head>
<body>

<%@ include file="navigation.jsp" %>

<h1>Create/Update Course Details</h1>

  <div class="container">
    <%
    boolean hasData = false;
            // Check if roll number exists and if student data exists using StudentModel
            if (rollNumber != null && !rollNumber.isEmpty()) {
                try {
                    hasData = StudentModel.hasStudentData(rollNumber);
                } catch (SQLException e) {
                    e.printStackTrace(); // Handle database exceptions (log or display error message)
                }
            }
    %>
    
    <% if (hasData) { %>
      <label for="studentName">Student Name:</label>
      <input type="text" id="studentName" name="studentName" 
             value="<%= studentName %>" required><br><br>

      <label for="email">Email:</label>
      <input type="email" id="email" name="email" 
             value="<%= email %>" ><br><br>

      <label for="phone">Phone Number:</label>
      <input type="text" id="phone" name="phone" 
             value="<%= phone %>" ><br><br>

      <label for="courseId">Course ID:</label>
      <input type="text" id="courseId" name="courseId" 
             value="<%= courseId %>" required><br><br>

      <label for="courseName">Course Name:</label>
      <input type="text" id="courseName" name="courseName"  
             value="<%= courseName %>" required><br><br>

      <label for="enrollmentDate">Enrollment Date:</label>
      <input type="date" id="enrollmentDate" name="enrollmentDate" 
             value="<%= enrollmentDate %>" ><br><br>
      <input type="submit" value="Update Course">
    </form>
    <% } else { %>
    <form action="create" method="post">

      <label for="studentName">Student Name:</label>
      <input type="text" id="studentName" name="studentName" required><br><br>

      <label for="email">Email:</label>
      <input type="email" id="email" name="email"><br><br>

      <label for="phone">Phone Number:</label>
      <input type="text" id="phone" name="phone"><br><br>

      <label for="courseId">Course ID:</label>
      <input type="text" id="courseId" name="courseId" required><br><br>

      <label for="courseName">Course Name:</label>
      <input type="text" id="courseName" name="courseName" required><br><br>
<label for="enrollmentDate">Enrollment Date:</label>
<input type="date" id="enrollmentDate" name="enrollmentDate" 
        required><br><br>

      <input type="submit" value="Create Course">
      </form>
    <% } %>
  </div>
</body>