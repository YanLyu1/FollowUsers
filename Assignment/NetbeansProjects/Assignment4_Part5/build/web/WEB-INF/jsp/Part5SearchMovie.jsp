<%-- 
    Document   : Part5SearchMovie
    Created on : Feb 16, 2019, 9:19:20 PM
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
        <h1> Searching Movies </h1>
        
        <form action="part5Controller.htm" method="post">
            Keyword:           
            <input type="text" name="keyword" required/>
            <br>
            <label>
                <input name="search" type="radio" value="title" checked/>Search By Title 
            </label> 
            <br>
            <label>
                <input name="search" type="radio" value="actor" />Search By Actor 
            </label> 
            <br>
            <label>
                <input name="search" type="radio" value="actress" />Search By Actress 
            </label> 
            <br>
            <input type="submit" value ="Search Movies"/>
            <input type="hidden" value ="search" name="hide"/>
        </form>
    </body>
</html>
