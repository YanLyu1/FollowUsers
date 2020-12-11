<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form commandName="user" method="post"
		enctype="multipart/form-data">
			First Name: <form:input path="fname" />
					<br />
			Select photo 1: <input type="file" name="photo[0]" />
					<br />
			Select photo 2: <input type="file" name="photo[1]" />
					<br />
			Select photo 3: <input type="file" name="photo[2]" />
					<br />
		<input type="submit" />
	</form:form>
</body>
</html>