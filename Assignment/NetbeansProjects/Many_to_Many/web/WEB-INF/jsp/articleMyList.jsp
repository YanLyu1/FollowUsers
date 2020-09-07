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
        <title>Article List</title>
    </head>
    <body>
        <h1>Here are all your articles</h1>
        <!--<form action="editArticle.htm" method="get">-->
            <table>
                <c:forEach items="${articleList}" var="article">
                    <tr>
                        <td>
                            ${article.user.userName}
                        </td>
                        <td>
                            ${article.content}
                        </td>
                        <td>
                            <a href="editArticle.htm?articleId=${article.articleId}&articleAction=edit&step=listOld">Edit</a>
                    </tr>
                </c:forEach>
            </table>
        <!--</form>-->
    </body>
</html>
