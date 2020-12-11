<%-- 
    Document   : Part5Welcome
    Created on : Feb 16, 2019, 9:13:03 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type='text/javascript' src='a.js'></script>
    </head>
    <body>
        <h1>Welcome to Our Movie Store</h1>
        <h2>Assignment 4 Part_5</h2>
        <p>Please Make Your Selection Below</p>
        <form method = "post" action = "part5Controller.htm">
            <select name="selection" >
                <option value ='bm'>Browse Movies</option>
                <option value ='add'>Add New Movie to Database</option>
            </select>
            <input type="submit" value="send" name="send">
            <input type="hidden" value="welcome" name="hide">
        </form>
    </body>
</html>
