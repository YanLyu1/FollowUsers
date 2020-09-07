<%-- 
    Document   : success
    Created on : Mar 8, 2019, 5:04:19 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
	<table>
		<tbody>
			<tr>
				<td>User Info:</td>
			</tr>
			<tr>
				<td><c:out value="${registerInfo.name}"></c:out></td>
			</tr>
			<tr>
				<td><c:out value="${registerInfo.age}"></c:out></td>
			</tr>
			<tr>
				<td><c:out value="${registerInfo.sex}"></c:out></td>
			</tr>
			<tr>
				<td><c:out value="${registerInfo.adress}"></c:out></td>
			</tr>
			<tr>
				<td><c:out value="${registerInfo.phone}"></c:out></td>
			</tr>
			<tr>
				<td><c:out value="${registerInfo.email}"></c:out></td>
			</tr>
			<tr>
				<td><c:out value="${registerInfo.favor}"></c:out></td>
			</tr>
		</tbody>
	</table>
</body>
</html>
