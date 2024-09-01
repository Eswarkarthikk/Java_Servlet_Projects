<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
  // Get user's name and roll number from session (assuming checkSession.jsp sets them)
  String name = (String) session.getAttribute("username");
  String rollNumber = (String) session.getAttribute("rollNumber");
%>
<%@ include file="navigation.jsp" %>

<div class="container">
  <h1>Welcome, Hi <%= name %> (<%= rollNumber %>)!</h1>
  <div class="message info">
    You have successfully logged in to the student portal! <br>
    Please enter your course details in the Create/Update form.
  </div>

  <div class="button-container">
    <a href="createorupdate.jsp" class="button">Create/Update Courses</a>
  </div>
</div>

</body>
</html>