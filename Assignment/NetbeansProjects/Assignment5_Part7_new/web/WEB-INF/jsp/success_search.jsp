<%-- 
    Document   : success_search
    Created on : Mar 9, 2019, 3:46:48 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Here are search results</h1>
        <c:set var="movieList" value="${requestScope.movieList}"/>
        <table>
            <th>id</th>
            <th>title</th>
            <th>actor</th>
            <th>actress</th>
            <th>genre</th>
            <th>year</th>
            
            <c:forEach var="movie" items="${movieList}">
                <tr>
                    <td>${movie.id}</td>
                    <td>${movie.title}</td>
                    <td>${movie.actor}</td>
                    <td>${movie.actress}</td>
                    <td>${movie.genre}</td>
                    <td>${movie.year}</td>
                </tr>
            </c:forEach>
            
        </table>
    </body>
</html>
