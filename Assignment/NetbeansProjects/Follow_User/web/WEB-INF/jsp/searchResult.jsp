<%-- 
    Document   : searchResult
    Created on : 2019-4-21, 18:52:35
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>-->
<c:import url="header.jsp">
    <c:param name="title" value="login"/>
    <%--<c:param name="locale" value="zh_CN"/>--%>
    <c:param name="h3" value="search results"/>
    <c:param name="locale" value="${language}"/>
    <%--<c:param name="locale" value="en_US"/>--%>
</c:import>
        <script>
            function articles(){
                document.getElementById('type').innerHTML = "<table border='1' align='center' width='800'>"
                + "<th>author</th><th>title</th><th>content</th><th>action</th>"
            <c:forEach var='article' items='${searchMap.articles}'>
                    + "<tr>"
                    + "<td align='center'><a href='friendArticle.htm?friendId=${article.user.userId}'>${article.user.userName}</a></td>"
                    + "<td align='center'>${article.title}</td>"
                    + "<td align='center'>${article.content}</td>"
                    + "<td align='center'><a href='viewArticle.htm?articleId=${article.articleId}&articleAction=details'>View Article</a></td>"
                    + "</tr>"
                    </c:forEach>
                    +"</table>";
            }
        </script>
        
        <script>
            function users(){
                document.getElementById('type').innerHTML = "<table border='1' align='center' width='800'>"
                <c:set var="me" value="${sessionScope.user}"/>
                + "<th>Name</th><th>Introduction</th><th>Action</th>"
        <c:forEach items="${searchMap.users}" var="user">
                + "<tr>"
                + "<td align='center'><a href='friendArticle.htm?friendId=${user.userId}'>${user.userName}</a></td>"
                + "<td align='center'>${user.introduction}</td>"
                + "<td align='center'>"
        <c:set var="act" value="follow"/>
            <c:forEach var="friend" items="${me.follewdUsers}">
                <c:if test="${user.userId == friend.userId}">
                    <c:set var="act" value="notFollow"/>
                </c:if>
            </c:forEach>
                + "<a href='follow.htm?follow=${user.userId}&browseAction=${act}'> ${act}</a></td>"
                + "</tr>"
        </c:forEach>
                +"</table>";
            }
        </script>
        
    <body>
        <br/><br/>
        <button class="btn btn-primary btn-lg btn-block" onclick="articles()">article</button>
        <button class="btn btn-primary btn-lg btn-block" onclick="users()">user</button>
        <br/><br/><br/><br/>
            <div id='type'>
        <c:set var="me" value="${sessionScope.user}"/>
        <c:set var="act" value="follow"/>
        <form action="follow.htm" method="get">
            <table border="1" align="center" width="800">
                <th>User Name</th>
                <th>Introduction</th>
                <th>Action</th>
                <c:forEach items="${searchMap.users}" var="user">
                    <tr>
                        <td align="center">
                            <a href="friendArticle.htm?friendId=${user.userId}">${user.userName}</a>
                        </td>
                        <td align="center">
                            ${user.introduction}
                        </td>
                        <td align="center">
                            <c:set var="act" value="follow"/>
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
            <br/><br/>
            <table border="1" align="center" width="800">
            <th>Author</th>
            <th>Title</th>
            <th>Content</th>
            <th>Action</th>
            <c:forEach items="${searchMap.articles}" var="article">
                
                <tr>
                    <td align="center">
                        <a href="friendArticle.htm?friendId=${article.user.userId}">${article.user.userName}</a>
                    </td>
                    <td align="center">
                        ${article.title}
                    </td>
                    <td align="center">
                        ${article.content}
                    </td>
                    <td align="center">
                        <a href="viewArticle.htm?articleId=${article.articleId}&articleAction=details">View Article</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        </div>
            <br/><br/><br/><br/><br/>
    </body>
    <c:import url="footer.jsp"/>
</html>
