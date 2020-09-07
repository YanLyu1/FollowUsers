<%-- 
    Document   : home
    Created on : Apr 11, 2019, 2:47:46 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--<html>-->
<!--    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>-->
<c:import url="header.jsp">
    <c:param name="title" value="home page"/>
    <c:param name="h3" value="home"/>
    <c:param name="locale" value="${language}"/>
</c:import>
    <body>
        <h1>Hello ${user.userName}, Here is your home page!</h1>
        <br/><br/>
        <!--<h2>upload articles</h2>-->
        <!--<a href="browseArticle.htm?articleAction=all">recommand news articles</a>-->
    </body>
    <c:import url="footer.jsp"/>
</html>
