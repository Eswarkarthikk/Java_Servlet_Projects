<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="test.ServiceModel"%>
<%@ page import="test.ServiceModel.Service"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Services</title>
    <style>
    body {
    margin: 0;
    font-family: Arial, sans-serif;
}

h2 {
    text-align: center;
    font-size: 28px;
    margin-bottom: 30px;
}

table {
    width: 80%; /* Set table width */
    margin: 50px auto; /* Center the table */
    border-collapse: collapse; /* Collapse table borders */
}

thead {
    background-color: #f0f8ff; /* Light blue background color */
}

thead th {
    padding: 15px; /* Add padding to header cells */
    font-size: 20px; /* Increase font size */
    text-align: left; /* Align text to the left */
}

tbody td {
    padding: 15px; /* Add padding to table cells */
    font-size: 20px; /* Increase font size */
}

tbody tr:nth-child(even) {
    background-color: #f2f2f2; /* Alternate row background color */
}

tbody tr:hover {
    background-color: #f0f0f0; /* Hover background color */
}
    </style>
</head>
<body>
<jsp:include page="navigation.jsp" />
    <h2>Services List</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Service ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
            <% 
                try {
                    List<Service> services = ServiceModel.getAllServices();
                    for (Service service : services) {
                        out.println("<tr>");
                        out.println("<td>" + service.getServiceId() + "</td>");
                        out.println("<td>" + service.getName() + "</td>");
                        out.println("<td>" + service.getDescription() + "</td>");
                        out.println("<td>" + service.getPrice() + "</td>");
                        out.println("</tr>");
                    }
                } catch (Exception e) {
                    out.println("<tr><td colspan='4'>Error loading data</td></tr>");
                    e.printStackTrace();
                }
            %>
        </tbody>
    </table>
</body>
</html>
