<style>
body {
    margin: 0;
    font-family: Arial, sans-serif;
}

nav {
    background-color: white;
    text-align: center;
    padding: 10px 0;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

nav a, nav .current-service, nav button {
    display: inline-block;
    color: black;
    background-color: #f0f0f0; /* Off-white background color */
    border: 2px solid #f0f0f0; /* Match background color */
    border-radius: 5px;
    text-decoration: none;
    padding: 10px 20px;
    margin: 0 10px;
    font-size: 14px;
    transition: background-color 0.3s ease, color 0.3s ease, border-color 0.3s ease;
}

nav a:hover, nav .current-service:hover, nav button:hover {
    background-color: #007bff; /* Blue color on hover */
    color: white; /* White text on hover */
    border-color: #007bff; /* Match background color on hover */
}

.form1 {
    display: inline-block;
    vertical-align: middle;
    margin-right: 10px;
}


    </style>

    <nav>
        <a class="student">current service ID: <%= session.getAttribute("rollNumber") %></a>
        <a href="add.jsp">Add Service</a>
        <a href="update.jsp">Update</a>
        <a href="delete.jsp">Delete</a>
        <a href="show.jsp">Show All Details</a>
        <form class="form1" action="logout" method="post">
            <button type="submit" style="background-color:red">Logout</button>
        </form>
    </nav>

