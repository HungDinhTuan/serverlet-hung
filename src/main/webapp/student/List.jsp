<%@ page import="org.example.serverletdemo.entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1>List student</h1>
    <a href="create-student">Create a new student</a>
    <table class="table">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Last Name</th>
                <th scope="col">First name</th>
                <th scope="col">Address</th>
                <th scope="col">City</th>
            </tr>
        </thead>
        <tbody>
            <% for (Student s : (List<Student>)request.getAttribute("students")){ %>
                <tr>
                    <th scope="row"><%= s.getId() %></th>
                    <td><%= s.getFirstName() %></td>
                    <td><%= s.getLastName() %></td>
                    <td><%= s.getAddress() %></td>
                    <td><%= s.getCity() %></td>
                    <td></td>
                    <td>
                        <a href="update-student?id=<%= s.getId() %>" class="btn btn-primary">Edit</a>
                        <a href="delete-student?id=<%= s.getId() %>" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this student?');">Delete</a>
                    </td>
                </tr>
            <%}%>
        </tbody>
    </table>
</div>
</body>
</html>