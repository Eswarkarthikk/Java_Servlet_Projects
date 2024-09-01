<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="test.StudentModel" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<style>
  .message {
    padding: 10px 20px;
    margin-bottom: 20px;
    border: 1px solid #ddd;
    border-radius: 5px;
  }

  .message.info {
    background-color: #f0f9ff;
    color: #333;
  }

  .message.warning {
    background-color: #ffecec;
    color: #8a6f6f;
  }

  .button-container {
    text-align: center;
  }

  .button {
    padding: 10px 20px;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 3px;
    cursor: pointer;
    transition: background-color 0.2s ease-in-out;
  }

  .button:hover {
    background-color: #3e8e41;
  }
</style>
</head>
<body>
<%
// Get user's roll number from session (assuming checkSession.jsp sets it)
  String rollNumber = (String) session.getAttribute("rollNumber");

  // Check if user has data in student course table (needs implementation)
  boolean hasData = StudentModel.hasStudentData(rollNumber); // Replace with actual implementation
%>
<%@ include file="navigation.jsp" %>

<div class="container"><center>
  <h1>Welcome, <%= rollNumber %>!</h1>
  <div class="message <% if (hasData) { %>info<% } else { %>warning<% } %>">
    <% if (hasData) { %>
      You have entered your data in the Student Course table.  <br>
      If you want to update your data, please click the button below.
    <% } else { %>
      You haven't entered your data in the Student Course table yet.  <br>
      Please enter your data through the Create/Update form.
    <% } %>
  </div>

  <% if (hasData) { %>
    <div class="button-container">
      <a href="createorupdate.jsp" class="button">Update Data</a>
    </div>
  <% } %>
</div>

</body>
</html>