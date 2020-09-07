<%-- 
    Document   : articleSearchResult
    Created on : Apr 12, 2019, 1:00:15 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Article Search Results</title>
    </head>-->
<c:import url="header.jsp">
    <c:param name="title" value="login"/>
    <c:param name="locale" value="${language}"/>
    <c:param name="h3" value="Articles"/>
    <%--<c:param name="locale" value="en_US"/>--%>
</c:import>
    <body>
        <!--<h1>Here are the search results according to your keyword</h1>-->
        <br/><br/>
        <table border="1" align="center" width="800">
            <th width="100">author</th>
            <th width="200">title</th>
            <th>content</th>
            <th>action</th>
            <c:forEach items="${articleList}" var="article">
                <tr align="center">
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
        <br/><br/><br/><br/>
    </body>
    <c:import url="footer.jsp"/>
</html>
