<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
<!--        <a href="addmovie.htm">Add Movie</a>
        <br>
        <a href="searchmovie.htm">Search Movie</a>-->
        <form method = "post" action = "action.htm">
            <select name="selection" >
                <option value ='bm'>Browse Movies</option>
                <option value ='add'>Add New Movie to Database</option>
            </select>
            <input type="submit" value="send" name="send">
        </form>
    </body>
</html>
