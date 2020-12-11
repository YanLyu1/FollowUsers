<%-- 
    Document   : welcome
    Created on : Feb 20, 2019, 5:53:43 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@taglib uri="/WEB-INF/tlds/readcsv" prefix="csv"%>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Par4</title>
    </head>
    <body>
        <form action="authenticationController.htm" method = "post">
            <h1> Enter File Name:</h1>
            <input type ="text" name ="file">
            <input type ="submit" name ="submit">
            <input type ="hidden" name ="welcome" value="yes">
            <%--<csv:Readcsv file="${requestScope.file}"></csv:Readcsv>--%>
        </form>
    </body>
</html>
