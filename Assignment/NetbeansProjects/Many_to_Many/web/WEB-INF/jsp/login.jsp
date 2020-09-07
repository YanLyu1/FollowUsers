<%-- 
    Document   : login
    Created on : Apr 11, 2019, 2:24:46 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<!--    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log in Your Account</title>
    </head>-->

<c:import url="header.jsp"/>
    <body>
        <h1>You can Log in your account here</h1>
        <form method="post" action="login.htm">
            User Name: <input type="text" name="userName" required><br>
            Password: <input type="password" name="password" required><br>
            <input type="submit" value="Log In"/>
            <input type="hidden" name="loginAction" value="true"/>
        </form>
    </body>
    
<c:import url="footer.jsp"/>
    
    
</html>