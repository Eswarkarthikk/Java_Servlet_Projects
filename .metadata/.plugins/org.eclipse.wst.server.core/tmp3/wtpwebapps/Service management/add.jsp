<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Service</title>
    <style>
body {
    margin: 0;
    font-family: Arial, sans-serif;
}

h1 {
    text-align: center;
    font-size: 24px;
    margin-bottom: 30px; /* Add space below the heading */
}

.form {
    max-width: 500px; /* Set maximum width for the form */
    margin: 0 auto; /* Center the form horizontally */
    padding: 20px;
    border: 2px solid #ccc;
    border-radius: 5px;
}

form label {
    display: block; /* Display labels as block elements */
    font-size: 18px;
    margin-bottom: 10px;
}

form input[type="text"],
form textarea,
form input[type="number"] {
    width: calc(100% - 20px); /* Set inputs to fill the available space */
    padding: 10px;
    margin-bottom: 20px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

form button[type="submit"] {
    display: block;
    width: 100%; /* Make the button full width */
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 5px;
    padding: 10px;
    font-size: 18px;
    cursor: pointer;
}

form button[type="submit"]:hover {
    background-color: #0056b3;
}


    </style>
</head>
<body>
<jsp:include page="navigation.jsp" />
    <h1>Add New Service</h1>
    <form class="form"action="create" method="post">
        Name: <input type="text" name="name" required><br>
        Description: <textarea name="description"></textarea><br>
        Price: <input type="number" step="0.01" name="price" required><br>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
