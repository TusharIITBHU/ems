<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>loginpage</title>
    <style>
        h1 {text-align: center;}
        h2 {text-align: center;}
        form {text-align: center;}
    </style>
</head>
<body>

<h1>Welcome to Loginpage</h1>
<h2>Enter Correct Username and Password</h2>
<form method="post" action="profilepage">
    Enter Username:<input type="text" name="username"><br><br>
    Enter Password:<input type="password" name="password"><br><br>
    <input type="submit" value="Login"><br><br>
</form>
<form method="post" action="newuser.jsp">
    <input type="submit" value="Sign Up">
</form>
</body>
</html>