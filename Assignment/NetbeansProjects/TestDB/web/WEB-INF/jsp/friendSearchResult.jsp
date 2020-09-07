<%-- 
    Document   : friendSearchResult
    Created on : Apr 12, 2019, 1:10:18 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Friend Search Result</title>
    </head>
    <body>
        <h1>Here are the search results according to your keyword</h1>
        <form action="follow.htm" method="get">
            <table>
                <th>User Name</th>
                <th>Introduction</th>
                <c:forEach items="${userList}" var="user">
                    <tr>
                        <td>
                            ${user.userName}
                        </td>
                        <td>
                            ${user.introduction}
                        </td>
                        <td>
                            <input type="submit" value="Follow"/>
                            <input type="hidden" name="follow" value="${user.userId}"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
