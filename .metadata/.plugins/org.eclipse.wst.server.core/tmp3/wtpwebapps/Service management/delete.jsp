<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Service</title>
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

form input[type="text"] {
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
    background-color: #dc3545; /* Red color for delete button */
    color: white;
    border: none;
    border-radius: 5px;
    padding: 10px;
    font-size: 20px; /* Increase font size */
    cursor: pointer;
}

form button[type="submit"]:hover {
    background-color: #c82333; /* Darker red color on hover */
}
    </style>
</head>
<body>
<jsp:include page="navigation.jsp" />
    <h1>Delete Service</h1>
    <form class="form" action="delete" method="post">
        Enter Service ID to Delete: <input type="text" name="serviceId" required>
        <button type="submit">Delete</button>
    </form>
</body>
</html>
