<%@ page session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<a href="/userapp/user/viewOwnPassage.htm">View-My-Passage</a>
<!-- 只能看点赞评论 不能查/修改的公共区域 -->
<c:forEach var="passage" items="${requestScope.passageList}">
	<form action="/userapp/user/viewOnePublicPassage.htm" method="POST" >
		<label >${passage.title}</label>
		<input type="hidden" name="passageId" value="${passage.passageId}">
		<input type="submit" value="view"/>
	</form>
	<form action="/userapp/user/viewAllPassage.htm" method="POST" >
		<input type="submit" value="${passage.thumbNum }"></br>
		<input type="hidden" name="passageId" value="${passage.passageId}">
	</form>
</c:forEach>
</body>
</html>