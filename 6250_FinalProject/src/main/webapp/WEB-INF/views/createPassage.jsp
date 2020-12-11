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
<form:form modelAttribute="passage" action="/userapp/user/create-passage-success.htm" method="POST">
<p><a href="createPassage.htm">Create A Passage</a>|<a href="home.htm">Update(meixiehao)</a></p><br/>
<div id="createP">
Passage Title: <form:input path="title"/> <form:errors path="title"/><br/>
Description: <form:input path="discription"/> <form:errors path="discription"/><br/>
Content: <form:input path="content"/> <br/>

<input type="submit" value="create"/>
</div>
</form:form>

</body>
</html>