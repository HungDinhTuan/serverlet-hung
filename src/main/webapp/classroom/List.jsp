<%@ page import="java.util.List" %>
<%@ page import="org.example.serverletdemo.entity.Classroom" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Class</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1>List student</h1>
    <a href="create-classroom">Create a class</a>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Room</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <% for (Classroom c : (List<Classroom>)request.getAttribute("classes")){ %>
        <tr>
            <th scope="row"><%= c.getIdClass() %></th>
            <td><%= c.getName() %></td>
            <td><%= c.getRoom() %></td>
            <td></td>
            <td>
                <a href="update-classroom?id=<%= c.getIdClass() %>" class="btn btn-primary">Edit</a>
                <a href="delete-classroom?id=<%= c.getIdClass() %>" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this class?');">Delete</a>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
</body>
</html>
