<%-- 
    Document   : LoginForm
    Created on : Feb 23, 2019, 1:20:58 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--where you get the view-->
        <form:form commandName="user" method="post">
            <!--username is the same as pojo-->
            <label>Username</label><form:input path="usename" type="text"/>
            <label>Password</label><form:input path="password" type="password"/>
            <input type="submit" name="login" value="Login"/>
        </form:form>
    </body>
</html>
