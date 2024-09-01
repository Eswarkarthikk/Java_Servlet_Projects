<style>
    nav {
        background-color: #f0f8ff; /* light blue */
        padding: 10px;
        text-align: center;
    }

    nav a {
        display: inline-block;
        padding: 10px 20px;
        margin: 0 10px;
        color: #333;
        text-decoration: none;
        border-radius: 5px;
        background-color: #add8e6; /* light blue */
        transition: background-color 0.3s;
    }
.student{
background-color: #ffff;
}
    nav a:hover {
        background-color: #87ceeb; /* lighter blue on hover */
    }

    nav form {
        display: inline;
    }

    nav button {
        background-color: red;
        color: white;
        border: none;
        cursor: pointer;
        padding: 10px 20px;
        border-radius: 5px;
    }

    nav button:hover {
        background-color: darkred;
    }
</style>

<nav>
<a class="student">Student ID: <%= session.getAttribute("rollNumber") %></a>
    <a href="createorupdate.jsp">Create or Update</a>
    <a href="delete.jsp">Delete</a>
    <a href="showdata.jsp">My Details</a>
    <a href="showall.jsp">Show All Details</a>
    <form action="logout" >
        <button type="submit">Logout</button>
    </form>
</nav>