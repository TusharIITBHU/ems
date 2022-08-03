<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>newuser</title>
</head>
<style>
    h1 {text-align: center;}
    form {text-align: center;}
</style>
<body>
<h1>Welcome, Enter Username and Password</h1>
<form method="post" action="newuser">
    Enter Username:<input type="text" name="username"><br><br>
    Enter Password:<input type="password" name="password"><br><br>
    <input type="submit" value="sign up"><br><br>
</form>

</body>
</html>