<%-- 
    Document   : success_part8
    Created on : Feb 3, 2019, 4:02:11 PM
    Author     : root
--%>

<%@page import="VO.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%int number = (int)request.getAttribute("number");%>
        <%ArrayList<Book> titles = (ArrayList<Book>)request.getAttribute("value");%>
        <h1>
            <%=number%> books added successfully!
        </h1>
        <h2>books titles are:</h2>
        <%
            for(Book book : titles){
        %>
        <p><%=book.getTitle()%></p>
        <%}%>
        <a href="part8Welcome.html">Click here to go back to homepage!</a>
    </body>
</html>
