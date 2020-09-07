<%-- 
    Document   : registerUserAccount
    Created on : Apr 10, 2019, 11:28:36 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Your Account</title>
    </head>
    <body>
        <h1>Input Your Information</h1>
        <h1>You Can get your new account</h1>
        <form action="register.htm" method="post">
            <c:if test="${error ne null}">
                <c:out value="You can not use ${error} as your User Name!"/><br>
            </c:if>
            User Name: <input type="text" name="userName" required><br>
            Password: <input type="password" name="password" required><br>
            Avatar Path: <input type="file" name="avatarPath" required><br>
            Introduction: <input type="text" name="introduction" required><br>
            <input type="submit" value="Create a New Account"/>
            <input type="hidden" name="registerAction" value="true"/>
        </form>
    </body>
</html>
