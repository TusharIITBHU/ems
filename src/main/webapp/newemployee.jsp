<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add Employee</title>
</head>
<style>
    h1 {text-align: center;}
    form {text-align: center;}
</style>
<body>
<h1>Add Employee</h1>
<form method="post" action="addemployee" modelAttribute="employee">
    Enter Name:<input type="text" name="empname"><br><br>
    Enter Department:<input type="text" name="empdepartment"><br><br>
    Enter Manager:<input type="text" name="empmanager" value="${employee.empmanager}"><br><br>
    <input type="submit" value="Save Employee"><br><br>
</form>

</body>
</html>