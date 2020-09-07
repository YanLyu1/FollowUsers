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

<c:import url="header.jsp">
    <c:param name="title" value="login"/>
    <%--<c:param name="locale" value="zh_CN"/>--%>
    <c:param name="h3" value="LOGIN YOUR ACCOUNT"/>
    <c:param name="locale" value="${language}"/>
    <%--<c:param name="locale" value="en_US"/>--%>
</c:import>
    <body>
<!--        <h1>You can Log in your account here</h1>-->
        <%--<c:if test="${error == none}">--%>
            <!--Email and Password dosen't match, if you don;t have an account, please register from here:<br/>-->
            <a href="register.htm">REGISTER</a>
        <%--</c:if>--%>
            
        <form method="post" action="login.htm">
            <div class="form-group">
                <label for="exampleInputEmail1">User Name: </label><input type="text" class="form-control" placeholder="Enter user name" name="userName" required><br>
            </div>
            <div class="form-group">
            <label for="exampleInputPassword1">Password: </label> <input class="form-control" id="exampleInputPassword1" placeholder="Password" type="password" name="password" required><br>
            </div>
            <input class="btn btn-primary btn-lg btn-block" type="submit" value="Log In"/>
            <input type="hidden" name="loginAction" value="in"/>
        </form>
<br/><br/>
            <form action="fogetPassword.htm" method="post">
                <input class="btn btn-primary btn-lg btn-block" type="submit" value="Foget Password"/>
            </form>
    </body>
    
<c:import url="footer.jsp"/>
</html>