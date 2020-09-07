<%-- 
    Document   : searchResult
    Created on : Feb 3, 2019, 10:59:54 AM
    Author     : root
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="Pojo.Movie"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>display by jstl & el</h1>
        <h2> You Searched For <c:out value="${requestScope.keyword}"/></h2>
        <h2>Here are the search result</h2>
        <table border="1" cellspacing="0">
            <th>title</th>
            <th>actor</th>
            <th>actress</th>
            <th>genre</th>
            <th>year</th>
            <c:forEach var="movie" items="${requestScope.list}">
            <tr>
                <td><c:out value="${movie.title}"/></td>
                <td><c:out value="${movie.actor}"/></td>
                <td><c:out value="${movie.actress}"/></td>
                <td><c:out value="${movie.genre}"/></td>
                <td><c:out value="${movie.year}"/></td>
            </tr>
            </c:forEach>
        </table>

        <a href="part7Welcome.html">Click here to go back to the main page</a>
    </body>
</html>
