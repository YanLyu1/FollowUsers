<%-- 
    Document   : searchMovie
    Created on : Mar 9, 2019, 3:46:34 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>search movie</h1>
        <form action="searchmovie.htm" method="post">
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
            <label>
                <input name="search" type="radio" value="id" />Search By ID 
            </label> 
            <br>
            <input type="submit" value ="Search Movies"/>
            <input type="hidden" value ="search" name="hide"/>
        </form>
    </body>
</html>
