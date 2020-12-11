<%@ page session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Register</title>
<meta charset="utf-8">
<script>
function loadXMLDoc()
{
	var xmlhttp;
	if (window.XMLHttpRequest)
	{
		//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlhttp=new XMLHttpRequest();
	}
	else
	{
		// IE6, IE5 浏览器执行代码
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			document.getElementById("register").innerHTML=xmlhttp.responseText;
		}
	}
	xmlhttp.open("POST","register.htm",true);
	xmlhttp.send();
}
</script>
</head>


<body>
<div id="register">
<form:form commandName="user" action="register.htm" method="POST">
<p><a href="login.htm">Login</a>|<a href="register.htm">Register</a></p><br/>
User Name: <form:input name="name" path="name" /> <form:errors path="name"/><label>"${requestScope.alert}"</label><br/>
Password: <form:input type="password" path="password"/> <form:errors path="password"/><br/>
Email: <form:input type="email" path="email"/> <form:errors path="email"/><br/>
Phone number: <form:input path="phoneNum"/> <form:errors path="phoneNum"/><br/>
<button   onclick="loadXMLDoc()">AJAX Button</button>
</form:form>
</div>
</body>

</body>
</html>