<%-- 
    Document   : contents
    Created on : Feb 2, 2019, 4:18:16 PM
    Author     : root
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList,servelet.Part6Servelet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Contents</h1>
        <table>
        <%
            ArrayList<StringBuffer> list = (ArrayList<StringBuffer>)request.getAttribute("list"); 
            for(StringBuffer item : list){
        %>
        
        <tr>
            <td>
                <p><%= item%></p>
            </td>
        </tr>
        
        <%}%>
        </table>
    </body>
</html>
