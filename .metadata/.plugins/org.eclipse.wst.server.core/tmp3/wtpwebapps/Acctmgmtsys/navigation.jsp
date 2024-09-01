<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .student {
            background-color: #ffffff;
        }
    </style>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand">Account Number: <%= session.getAttribute("rollNumber") %></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="CreateorUpdate.jsp">Create or Update</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="delete.jsp">Delete</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="ShowData.jsp">My Details</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="ShowAll.jsp">Show All Details</a>
            </li>
            <li class="nav-item">
                <form class="form-inline" action="logout" method="post">
                    <button class="btn btn-danger" type="submit">Logout</button>
                </form>
            </li>
        </ul>
    </div>
</nav>

<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

