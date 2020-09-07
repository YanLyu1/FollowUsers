<%-- 
    Document   : home
    Created on : Apr 11, 2019, 2:47:46 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Hello ${user.userName}, Here is your home page!</h1>
        <h2>upload articles</h2>
        <a href="uploadArticle.htm">upload</a><br>
        <a href="browseArticle.htm?articleAction=browse">browse all articles</a>
        
        <h2>search articles</h2>
        <form method="get" action="search.htm">
            Article Keyword: <input type="text" name="keyword"/>
            <input type="submit" value="Search Article"/>
            <input type="hidden" name="searchType" value="article"/>
        </form>
        
        <h2>search friends</h2>
        <form method="get" action="search.htm">
            Article Keyword: <input type="text" name="keyword"/>
            <input type="submit" value="Search Friend"/>
            <input type="hidden" name="searchType" value="user"/>
        </form>
    </body>
</html>
