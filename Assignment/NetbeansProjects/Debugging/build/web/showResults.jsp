<%-- 
    Document   : showResults
    Created on : Feb 5, 2019, 9:09:39 PM
    Author     : lijin
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Show Results!~~~~~</h1>
        <table>
        <%
            ArrayList<String> list = (ArrayList<String>)session.getAttribute("list");
            for(String item : list){
        %>
        
        <tr>
            <td>
                <p><%=item%></p>
            </td>
        </tr>
        
        <%}%>
        <p><%=list.size()%></p>
        </table>
    </body>
</html>
