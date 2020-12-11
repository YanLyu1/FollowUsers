<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Public Passage</title>
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<label>Title: "${sessionScope.passage.title}"</label><br/>
	<label>Description: "${sessionScope.passage.discription}"</label><br/>
	<label>Content: "${sessionScope.passage.content}"</label><br/>
	<c:forEach var="comment" items="${requestScope.commentList}">
		<label>User: "${comment.user }"</label>
		<label>  Says: "${comment.content }"</label><br/>
	</c:forEach>
	
	<form action="/userapp/user/viewOnePublicPassage.htm" method="get">
		<input type="text" name="commentContent">
		<input type="hidden" name = "passageId" value="${passage.passageId}">
		<input type="submit" value="comment">
	</form>
	<a href="viewAllPassage.htm">Back To View</a>
	
</body>
</html>