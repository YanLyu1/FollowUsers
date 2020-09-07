<%-- 
    Document   : register2
    Created on : Mar 8, 2019, 5:03:15 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
	<form action="login.do" method="post">
		<table>
			<tbody>
				<tr>
					<td>地址:<input name="adress" type="text" />
					</td>
				</tr>
				<tr>
					<td>电话:<input name="phone" type="text" />
					</td>
				</tr>
				<tr>
					<td>电子邮件:<input name="emial" type="text" />
					</td>
				</tr>
				<tr>
					<td align="center">
					<input type="submit" value="上一步" name="_target1" /> 
					<input type="submit" value="下一步" name="_target3" /> 
					<input type="submit" value="取消" name="_cancel" />
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>
