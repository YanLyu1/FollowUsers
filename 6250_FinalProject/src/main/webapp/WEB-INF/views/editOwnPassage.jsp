<%@ page session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	if(window.confirm("You Sure Want delete this?")){
		window.location.href = "http://localhost:8080/userapp/user/deletePassage.htm?passageId=${passage.passageId}";
	}else{
		window.location.href = "http://www.baidu.com";
	}
}
</script>
<meta charset="UTF-8">
<title>EDIT</title>
</head>
<body>

<form:form modelAttribute="passage" action="/userapp/user/viewOwnPassage.htm?pId=${passage.passageId}" method="POST">
	Passage Title: <form:input path="title" value="${passage.title }"/> <form:errors path="title"/><br/>
	Description: <form:input path="discription" value="${passage.discription }"/> <form:errors path="discription"/><br/>
	Content: <form:input path="content" value="${passage.content }"/> <br/>
	<input type="submit" value="update"/>
	<button type="button" onclick="myFunction()" >Delete</button>
</form:form>

	


</body>
</html>