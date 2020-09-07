<%-- 
    Document   : bookview
    Created on : Feb 15, 2019, 9:41:30 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="books" type="java.util.ArrayList" scope="request"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Book List</h1>
        <%
            //loop thru the ArrayList
            for(int i = 0; i < books.size();i++){
                out.println(books.get(i) + "<br>");
            }
        %>
    </body>
</html>
