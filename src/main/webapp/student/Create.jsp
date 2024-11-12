<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">

    <h1>Create student</h1>
    <form method="post" action="">
        <div class="mb-3">
            <label class="form-label">Last Name</label>
            <input type="text" name="LastName" class="form-control">
        </div>
        <div class="mb-3">
            <label class="form-label">First Name</label>
            <input type="text" name="FirstName" class="form-control">
        </div>
        <div class="mb-3">
            <label class="form-label">Address</label>
            <input type="text" name="Address" class="form-control">
        </div>
        <div class="mb-3">
            <label class="form-label">City</label>
            <input type="text" name="City" class="form-control">
        </div>
        <button type="submit" class="btn btn-success">Submit</button>
    </form>
</div>
</body>
</html>