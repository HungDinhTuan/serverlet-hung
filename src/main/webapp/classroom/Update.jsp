<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.example.serverletdemo.entity.Classroom" %>
<%
    Classroom classroom = (Classroom) request.getAttribute("classroom");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1>Update Student</h1>
    <form method="post" action="update-classroom?id=<%= classroom %>">
        <div class="mb-3">
            <label>Name:</label>
            <input type="text" name="LastName" class="form-control" value="<%= classroom.getName() %>">
        </div>
        <div class="mb-3">
            <label>Room:</label>
            <input type="text" name="FirstName" class="form-control" value="<%= classroom.getRoom() %>">
        </div>
        <button type="submit" class="btn btn-success">Save</button>
    </form>
</div>
</body>
</html>

