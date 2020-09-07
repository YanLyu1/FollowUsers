<%-- 
    Document   : login
    Created on : Feb 16, 2019, 2:40:45 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>login page</h1>
        <form action ="authentication.htm" method="post">
            user name: <input type="text" name="username"/><br/>
            password: <input type="password" name="password"/><br/>
            <input type="hidden" value="login" name="option"/>
            <input type="submit" name="submit"/>
        </form>
    </body>
</html>
