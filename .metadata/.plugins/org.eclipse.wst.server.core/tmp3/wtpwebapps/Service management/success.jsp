<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="test.ServiceModel" %>
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
  String rollNumber = (String) session.getAttribute("rollNumber");
String password = (String) session.getAttribute("password");
  boolean hasData = ServiceModel.validateUser(rollNumber,password); %>

<%@ include file="navigation.jsp" %>

<div class="container"><center>
  <div class="message <% if (hasData) { %>info<% } else { %>warning<% } %>">
    <% if (hasData) { %>
      
  <h1>Welcome back, <%= rollNumber %>!</h1>
      please go to services to view your services 
    <% } else { %>
      welcome to the service management system 
      please go to services to add or update  your services 
    <% } %>
  </div>
</div>

</body>
</html>