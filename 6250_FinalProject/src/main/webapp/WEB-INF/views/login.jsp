<%@ page session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<form:form commandName="user" action="user.htm" method="POST">
<p><a href="login.htm">Login</a>|<a href="register.htm">Register</a></p><br/>
<div id="login">
User Name: <form:input path="name"/> <form:errors path="name"/><br/>
Password: <form:input path="password"/> <form:errors path="password"/><br/>
<input type="submit" value="login"/>
</div>
</form:form>

</body>
</html>