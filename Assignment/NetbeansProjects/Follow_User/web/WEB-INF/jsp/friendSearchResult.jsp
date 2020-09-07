<%-- 
    Document   : friendSearchResult
    Created on : Apr 12, 2019, 1:10:18 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Friend Search Result</title>
    </head>-->
<c:import url="header.jsp">
    <c:param name="title" value="home page"/>
    <c:param name="h3" value="your friends"/>
    <c:param name="locale" value="${language}"/>
</c:import>
    <body>
        <c:set var="me" value="${sessionScope.user}"/>
        <c:set var="act" value="follow"/>
        <br/><br/>
        <form action="follow.htm" method="get">
            <table border="1" align="center" width="800">
                <th>Name</th>
                <th>Introduction</th>
                <th>ACTION </th>
                <c:forEach items="${userList}" var="user">
                    <tr>
                        <td align="center">
                            <a href="friendArticle.htm?friendId=${user.userId}">${user.userName}</a>
                        </td>
                        <td align="center">
                            ${user.introduction}
                        </td>
                        <td align="center">
                            <c:forEach var="friend" items="${me.follewdUsers}">
                                <c:if test="${user.userId == friend.userId}">
                                    <c:set var="act" value="notFollow"/>
                                </c:if>
                            </c:forEach>
                            <a href="follow.htm?follow=${user.userId}&browseAction=${act}"> ${act}</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
        <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
    </body>
    <c:import url="footer.jsp"/>
</html>
