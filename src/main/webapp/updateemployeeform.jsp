<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update Employee</title>
</head>
<style>
    form {text-align: center;}
</style>
<body>
<h1>Update details</h1>
<form method="post" action="updateemployee?empid=${emp.empid}" modelAttribute="emp">
    Enter Name:<input type="text" name="empname"><br><br>
    Enter Department:<input type="text" name="empdepartment"><br><br>
    Enter Manager:<input type="text" name="empmanager"><br><br>
    <input type="submit" value="Save Employee"><br><br>
</form>

</body>
</html>