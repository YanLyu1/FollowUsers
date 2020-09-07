<%-- 
    Document   : form-success
    Created on : Feb 23, 2019, 1:36:00 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        ${sessionScope.USER}
        
        <form name="courseadd" method="post" action="">
            <label>course name:</label><input type="text" name="coursename"/>
            <label>course crn</label><input type="text" name="coursecrn"/>
            <input type="submit" value="Add coutse"/>
        </form>
    </body>
</html>
