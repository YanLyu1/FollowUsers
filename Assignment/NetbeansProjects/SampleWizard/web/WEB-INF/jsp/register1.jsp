<%-- 
    Document   : register1
    Created on : Mar 8, 2019, 5:02:51 PM
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
					<td>姓名：<input name="name" type="text" />
					</td>
				</tr>
				<tr>
					<td>年龄：<input name="age" type="text" />
					</td>
				</tr>
				<tr>
					<td>性别: <select name="sex">
							<option value="Y">男</option>
							<option value="X">女</option>
					</select>
					</td>
				</tr>
				<tr>
					<td align="center">
					    <input type="submit" value="上一步"name="_target0" /> 
						<input type="submit" value="下一步"name="_target2" /> 
						<input type="submit" value="取消" name="_cancel" />
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>
