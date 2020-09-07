<%-- 
    Document   : searchResult
    Created on : Feb 3, 2019, 10:59:54 AM
    Author     : root
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="list" value="${sessionScope.list}"/>
        <c:set var="keyword" value="${sessionScope.keyword}"/>
           
        
        <p> You Searched For ${keyword}</p>
        
        <h1>Here are the search result</h1>
        
        <table>
            <th>Title</th>
            <th>Actor</th>
            <th>Actress</th>
            <th>Genre</th>
            <th>Year</th>
            <c:forEach var="movie" items="${list}">
            <tr>
                <td>${movie.title}</td>
                <td>${movie.actor}</td>
                <td>${movie.actress}</td>
                <td>${movie.genre}</td>
                <td>${movie.year}</td>
            </tr>
            </c:forEach>
        </table>
        <a href="part7Welcome.htm">Click here to go back to the main page</a>
    </body>
</html>
