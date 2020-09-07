<%-- 
    Document   : changeUserStatus_Admin
    Created on : Apr 11, 2019, 4:16:13 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change User Status</title>
    </head>
    <body>
        <h1>You are admin, you can change user status here</h1>
        <form action="changeStatus.htm" method="get">
            <table>
                <th>User ID</th>
                <th>User Name</th>
                <th>Status</th>
                <th>drop service</th>
                <th>resume service</th>
                <c:forEach var="user" items="${userList}">
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.userName}</td>
                    <td>${user.status}</td>
                    <td><a href="changeStatus.htm?userId=${user.userId}&changeStatus=drop">drop</a></td>
                    <td><a href="changeStatus.htm?userId=${user.userId}&changeStatus=resume">resume</a></td>
                </tr>
                </c:forEach>
            </table>
            
        </form>
    </body>
</html>
