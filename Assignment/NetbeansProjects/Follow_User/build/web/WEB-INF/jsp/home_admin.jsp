<%-- 
    Document   : home_admin
    Created on : Apr 11, 2019, 2:54:15 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrator's Home Page</title>
    </head>
    
    <body>-->
<c:import url="header.jsp">
        <c:param name="title" value="register"/>
        <%--<c:param name="locale" value="zh_CN"/>--%>
        <c:param name="h3" value="administrator"/>
        <%--<c:param name="locale" value="en_US"/>--%>
        <c:param name="locale" value="${language}"/>
    </c:import>

        <h1></h1>
        <h2>change user status</h2>
        <a href="changeStatus.htm">change user status</a>
        <h2>add ad to page</h2>
        <h1></h1>
    </body>
     <c:import url="footer.jsp"/>
</html>
