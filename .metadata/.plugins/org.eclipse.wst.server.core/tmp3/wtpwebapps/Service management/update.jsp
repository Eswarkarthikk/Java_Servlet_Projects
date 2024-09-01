<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="test.ServiceModel"%>
<%@ page import="test.ServiceModel.Service"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Service</title>
    <style>
    body {
    margin: 0;
    font-family: Arial, sans-serif;
}

h1 {
    text-align: center;
    font-size: 24px;
    margin-bottom: 30px;
}

.form {
    max-width: 500px;
    margin: 50px auto; /* Center the form */
    padding: 20px;
    border: 2px solid #ccc;
    border-radius: 5px;
}

form label {
    display: block;
    font-size: 18px; /* Increase font size */
    margin-bottom: 10px;
}

form input[type="text"],
form textarea,
form input[type="number"] {
    width: calc(100% - 20px);
    padding: 10px;
    margin-bottom: 20px;
    font-size: 18px; /* Increase font size */
    border: 1px solid #ccc;
    border-radius: 5px;
}

form button[type="submit"] {
    display: block;
    width: 100%;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 5px;
    padding: 10px;
    font-size: 20px; /* Increase font size */
    cursor: pointer;
}

form button[type="submit"]:hover {
    background-color: #0056b3;
}
    </style>
</head>
<body>

    <jsp:include page="navigation.jsp" />
    <h1>Update Service</h1>
    <form class="form"action="update.jsp" method="post">
        Enter Service ID to Update: <input type="text" name="serviceId" required>
        <button type="submit">Fetch Details</button>
    </form>

    <% 
        String serviceIdStr = request.getParameter("serviceId");
        if (serviceIdStr != null && !serviceIdStr.isEmpty()) {
            try {
                int serviceId = Integer.parseInt(serviceIdStr);
                ServiceModel.Service service = ServiceModel.getServiceById(serviceId);

                if (service != null) {
    %>
                    <form class="form"action="update" method="post">
                        <input type="hidden" name="serviceId" value="<%= service.getServiceId() %>">
                        Name: <input type="text" name="name" value="<%= service.getName() %>" required><br>
                        Description: <textarea name="description"><%= service.getDescription() %></textarea><br>
                        Price: <input type="number" step="0.01" name="price" value="<%= service.getPrice() %>" required><br>
                        <button type="submit">Update</button>
                    </form>
    <%
                } else {
                    out.println("<p>Service not found. Please check the ID and try again.</p>");
                }
            } catch (Exception e) {
                out.println("<p>Error processing request: " + e.getMessage() + "</p>");
            }
        }
    %>
</body>
</html>
