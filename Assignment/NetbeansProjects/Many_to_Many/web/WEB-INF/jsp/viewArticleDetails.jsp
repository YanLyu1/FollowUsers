<%-- 
    Document   : viewArticleDetails
    Created on : Apr 12, 2019, 5:47:44 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Article Details</title>
    </head>
    <body>
        <h1>You can see the details of article</h1>
        
            <table>
                <tr>
                    <td>Author</td>
                    <td>${article.user.userName}</td>
                </tr>

                <tr>
                    <td>Content</td>
                    <td>${article.content}</td>
                </tr>

                <tr>
                    <td>like number</td>
                    <td>${article.likeNumber}</td>
                    <td>
                        <form action="" method="get"/>
                        <input type="submit" value="like"/>
                        <input type="hidden" name="articleAction" value="like"/>
                        <input type="hidden" name="articleId" value="${article.articleId}"/>
                        </form>
                    </td>
                </tr>

                <tr>
                    <td>comment</td>
                    <td>
                        <c:forEach items="${article.commentList}" var="conmment">
                    <ul>
                        ${conmment.content}
                    </ul>
                        </c:forEach>
                    </td>
                    <td>
                        <form action="addComment.htm" method="post">
                        <input type="text" name="comment"/>
                        <input type="hidden" name="articleAction" value="comment"/>
                        <input type="hidden" name="articleId" value="${article.articleId}"/>
                        <input type="submit" value="Add Comment"/>
                        </form>
                    </td>
                </tr>
            </table>
    </body>
</html>
