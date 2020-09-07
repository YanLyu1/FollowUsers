<%-- 
    Document   : Display
    Created on : Feb 20, 2019, 4:19:59 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/readcsv" prefix="csv"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Contents for CSV File</h1>
        <csv:Readcsv file="${requestScope.file}"></csv:Readcsv>
    </body>
</html>
