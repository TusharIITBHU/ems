<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Your Profile</title>
    <style>
        h1 {text-align: center;}
        form {text-align: center;}
    </style>
</head>
<body>
<h1>${user.username}</h1>
<h1>${username}</h1>
<h1>${User.username}</h1>
<h1>${Username}</h1>
<div align="center">
    <h1>Employee Details</h1>
    <a href="/newemployeeform">Add Employee</a>
    <table border="15" >
        <tr>
            <th>Employee Id</th>
            <th>Name</th>
            <th>Department</th>
            <th>Manager</th>
        </tr>
        <c:forEach var="emp" items="${list}">
            <tr>
                <td><c:out value="${emp.empid}"/></td>
                <td><c:out value="${emp.empname}"/></td>
                <td><c:out value="${emp.empdepartment}"/></td>
                <td><c:out value="${emp.empmanager}"/></td>
                <td><a href="/updateemployeeform?empid=${emp.empid}">Update</a></td>
                <td><a href="/deleteemployee?empid=${emp.empid}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<form method="post" action="/">
    <input type="submit" value="Logout">
</form>
</body>
</html>