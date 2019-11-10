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
        <title>Article List</title>
    </head>
    <body>
        <h1>Here are all your articles</h1>
        <h1>${size}</h1>-->
<c:import url="header.jsp">
    <c:param name="title" value="my articles"/>
    <c:param name="h3" value="My articles"/>
    <%--<c:param name="locale" value="zh_CN"/>--%>
    <c:param name="locale" value="${language}"/>
</c:import>

    <script>
        function mine(){
            document.getElementById('type').innerHTML = "<table border='1' align='center' width='800'>"
            + "<th>AUTHOR</th><th>TITLE</th><th>CATEGORY</th><th>STATUS</th><th>CONTENT</th><th>ACTION</th><th>DELETE</th>"
                <c:forEach var='article' items='${articlesMap.mine}'>
                    <c:set var="status" value="PRIVATE"/>
                    <c:if test="${article.pubpri}">
                        <c:set var="status" value="PUBLIC"/>
                    </c:if>
                    + "<tr>"
                    + "<td align='center'>${article.user.userName}</td>"
                    + "<td align='center'>${article.title}</td>"
                    + "<td align='center'>${article.category.category}</td>"
                    + "<td align='center'>${status}</td>"
                    + "<td align='center'>${article.content}</td>"
                    + "<td align='center'><a href='editArticle.htm?articleId=${article.articleId}&articleAction=edit&step=listOld'>Edit</a></td>"
                    + "<td align='center'><a href='deleteArticle.htm?articleId=${article.articleId}'>Delete Article</a></td>"
                    + "</tr>"
                </c:forEach>
            +"</table>";
            }
    </script>
    
    <script>
        function like(){
            document.getElementById('type').innerHTML = "<table border='1' align='center' width='800'>"
            + "<th>AUTHOR</th><th>TITLE</th><th>CONTENT</th><th>ACTION</th>"
            <c:forEach var='article' items='${articlesMap.like}'>
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
        

<div class="modal-body">
    <div class="row">
        <div class="col-xs-12">
            <div class="well">
                <button class="btn btn-primary btn-lg btn-block" onclick="mine()">My Articles</button>
                <button class="btn btn-primary btn-lg btn-block" onclick="like()">Article I Liked</button>
                <br/><br/>
                <div id='type'>    
            <table border="1" align="center" width="800">
                <th align="center" width="50">AUTHOR</th>
                <th align="center" width="50">TITLE</th>
                <th align="center" width="50">Category</th>
                <th align="center" width="50">STATUS</th>
                <th align="center" width="100">CONTENT</th>
                <th align="center" width="50">ACTION</th>
                <th align="center" width="50">DELETE</th>
                <c:forEach items="${articlesMap.mine}" var="article">
                    <div class="form-group">
                        
                    <tr>
                        <td align="center">
                            ${article.user.userName}
                        </td>
                        <td align="center">
                            ${article.title}
                        </td>
                        <td align="center">
                            ${article.category.category}
                        </td>
                        <td align="center">
                            <c:if test="${article.pubpri}">
                                public
                            </c:if>
                            <c:if test="${article.pubpri ne true}">
                                private
                            </c:if>
                        </td>
                        <td align="center">
                            ${article.content}
                        </td>
                        <td align="center">
                            <c:if test="${article.user.userName == user.userName}">
                                <a href="editArticle.htm?articleId=${article.articleId}&articleAction=edit&step=listOld">Edit</a>
                            </c:if>
                            <c:if test="${article.user.userName ne user.userName}">
                                <a href="viewArticle.htm?articleId=${article.articleId}&articleAction=details">View Article</a>
                            </c:if>
                        </td>
                        <td align="center">
                            <a href="deleteArticle.htm?articleId=${article.articleId}">Delete Article</a>
                        </td>
                    </tr>
                    </div>
                </c:forEach>
            </table>   
                </div></div></div></div></div>
    </body>
    <c:import url="footer.jsp"/>
</html>
