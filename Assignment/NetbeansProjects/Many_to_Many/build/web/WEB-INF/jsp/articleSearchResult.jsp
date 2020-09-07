<%-- 
    Document   : articleSearchResult
    Created on : Apr 12, 2019, 1:00:15 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Article Search Results</title>
    </head>
    <body>
        <h1>Here are the search results according to your keyword</h1>
        <table >
            <th>author</th>
            <th>content</th>
            <c:forEach items="${articleList}" var="article">
                
                <tr>
                    <td>
                        
                        ${article.user.userName}
                    </td>
                    <td>
                        ${article.content}
                    </td>
                    <td>
                        <a href="viewArticle.htm?articleId=${article.articleId}&articleAction=details">View Article</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
