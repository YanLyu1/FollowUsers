<%-- 
    Document   : searchResult
    Created on : Feb 3, 2019, 10:59:54 AM
    Author     : root
--%>

<%@page import="VO.Movie"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String keyword = (String)request.getAttribute("keyword");
            ArrayList<Movie> movieList = (ArrayList<Movie>)request.getAttribute("list");
        %>
        
        <p> You Searched For 
        <%=keyword%></p>
        
        <h1>Here are the search result</h1>
        
        <table>
            <%for(Movie movie : movieList){%>
            <tr>
                <td>Movie Title: </td>
                <td><%=movie.getTitle()%></td>
            </tr>
            <tr>
                <td>Lead Actor: </td>
                <td><%=movie.getActor()%></td>
            </tr>
            <tr>
                <td>Lead Actress: </td>
                <td><%=movie.getActress()%></td>
            </tr>
            <tr>
                <td>Genre: </td>
                <td><%=movie.getGenre()%></td>
            </tr>
            <tr>
                <td>Year: </td>
                <td><%=movie.getYear()%></td>
            </tr>
            <%}%>
        </table>
        <a href="part7Welcome.html">Click here to go back to the main page</a>
    </body>
</html>
