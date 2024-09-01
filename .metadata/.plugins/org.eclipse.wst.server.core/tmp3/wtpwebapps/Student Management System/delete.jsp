<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Data</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            text-align: center;
        }

        .container {
            width: 80%;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        h1 {
            margin-bottom: 20px;
        }

        p {
            margin-bottom: 20px;
        }

        input[type="submit"] {
            background-color: green; /* Red button color */
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

      input[type="submit"]:hover {
    background-color: #28a745; /* Darker green on hover */
}

    </style>
</head>
<body>
    <div class="container">
        <jsp:include page="navigation.jsp" />
        <%
            HttpSession Session = request.getSession();
            String rollNumber = (String) session.getAttribute("rollNumber");

            if (rollNumber != null) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "");
                    PreparedStatement ps = conn.prepareStatement("SELECT * FROM student WHERE rollNumber = ?");
                    ps.setString(1, rollNumber);
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
        %>
                        <h1>Delete Your Data</h1>
                        <form action="delete" method="post">
                            <p>You have added your data to the database. Are you sure you want to delete it?</p>
                            <input type="hidden" name="rollNumber" value="<%= rollNumber %>">
                            <input type="submit" value="Delete Your Data">
                        </form>
        <%              
                    } else {
                        out.println("<p>You haven't added your data to the database.</p>");
                    }

                    rs.close();
                    ps.close();
                    conn.close();
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                out.println("<p>You haven't logged in.</p>");
            }
        %>
    </div>
</body>
</html>
