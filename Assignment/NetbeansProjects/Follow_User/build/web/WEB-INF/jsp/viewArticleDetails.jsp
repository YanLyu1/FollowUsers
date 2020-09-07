<%-- 
    Document   : viewArticleDetails
    Created on : Apr 12, 2019, 5:47:44 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Article Details</title>
    </head>-->
<c:import url="header.jsp">
    <c:param name="title" value="login"/>
    <%--<c:param name="locale" value="zh_CN"/>--%>
    <c:param name="h3" value="Artice deatils"/>
    <c:param name="locale" value="${language}"/>
    <%--<c:param name="locale" value="en_US"/>--%>
</c:import>
    <body>
<div class="card" style="width: 143rem;">
  <!--<img src="upload/blue.png" class="card-img-top" alt="blue.png">-->
  <ul class="list-group list-group-flush">
    <li class="list-group-item">TITLE: ${article.title}</li>
    <li class="list-group-item">CONTENT: ${article.content}</li>
    <li class="list-group-item">AUTHOR: ${article.user.userName}</li>
    <li class="list-group-item">CATEGORY: ${article.category.category}</li>
    <li class="list-group-item">LIKE NUMBET: ${article.likeNumber}<br/>
        By: 
        <c:forEach var="likedby" items="${article.likedBy}">
            <a href="friendArticle.htm?friendId=${likedby.userId}">${likedby.userName} </a>, 
        </c:forEach>
    </li>
    <li class="list-group-item">COMMENTS:
        <c:forEach items="${article.commentList}" var="conmment">
            <p>
                <a href="friendArticle.htm?friendId=${conmment.commentBy.userId}">${conmment.commentBy.userName}: </a>
                ${conmment.content}
            </p>
        </c:forEach>
    </li>
  </ul>
  <div class="card-body" >
    <form action="addComment.htm" method="post">
        <input class="form-control" placeholder="comment" type="text" name="comment"/>
        <input type="hidden" name="articleAction" value="comment"/>
        <input type="hidden" name="articleId" value="${article.articleId}"/><br/>
        <input class="btn btn-primary btn-lg btn-block" type="submit" value="Add Comment"/>
    </form>
        <br/><br/>
            <form action="likeArticle.htm" method="get">
                <input class="btn btn-primary btn-lg btn-block" type="submit" value="like"/>
                <input type="hidden" name="articleAction" value="like"/>
                <input type="hidden" name="articleId" value="${article.articleId}"/>
            </form>
  </div>
</div>
    </body>
    <c:import url="footer.jsp"/>
</html>
