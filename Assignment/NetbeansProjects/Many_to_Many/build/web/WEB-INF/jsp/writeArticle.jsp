<%-- 
    Document   : WriteArticle
    Created on : Apr 11, 2019, 6:23:25 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create your articles here</title>
    </head>
    <body>
        <h1>Write Article.jsp</h1>
        <form action="uploadArticle.htm" method="post">
            <c:if test="${article ne null}">
                content: <input type="text" name="content" value="${article.content}"/>
                <input type="hidden" name="step" value="editArticle"/>
                <input type="hidden" name="articleAction" value="edit"/>
                <input type="hidden" name="articleId" value="${article.articleId}"/>
                <input type="submit" value="Edit Article"/>
            </c:if>
             
            <c:if test="${article == null}">
                content: <input type="text" name="content"/>
                Image: <input type="file" name="image"/>
                <input type="hidden" name="articleAction" value="write"/>
                <input type="submit" value="Upload Article"/>
            </c:if>  
        </form>
    </body>
</html>
