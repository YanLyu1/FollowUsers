<%-- 
    Document   : Part5AddMovie
    Created on : Feb 16, 2019, 9:19:39 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="part7Add.htm" method="post">
            <p>Movie Title: </p>
            <input type="text" name="title" required/><br>
            <p>Lead Actor: </p>
            <input type="text" name="actor" required/><br>
            <p>Lead Actress: </p>
            <input type="text" name="actress" required/><br>
            <p>Genre: </p>
            <input type="text" name="genre" required/><br>
            <p>Year: </p>
            <input type="text" name="year" required/><br>
            <input type="submit" name="add" value="Add Movie"/>
            <input type="hidden" name="hide" value="add"/>
        </form>
    </body>
</html>
