<%@ page session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script>
function myFunction(){
		window.location.href = "http://localhost:8080/userapp/user/createPassage.htm"
}
</script>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<a href="/userapp/user/viewAllPassage.htm">View-Public-Passage</a>
<!-- user自己写的 能看能查能改 -->
<div id="viewOwnPassage">
	<c:forEach var="passage" items="${requestScope.passageList}">
		<form method="POST" action="/userapp/user/editOwnPassage.htm">
			<label>"${passage.title}" ></label>
			<input type="hidden" name="passageId" value="${passage.passageId}" />
			<input type="submit" value="Edit" >
			<br/>
		</form>	
	</c:forEach>
	<br/>
	<button type="button" onclick="myFunction()" >Create</button>
</div>	
	





</body>
</html>