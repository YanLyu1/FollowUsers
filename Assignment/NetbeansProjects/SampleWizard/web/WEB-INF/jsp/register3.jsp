<%-- 
    Document   : register3
    Created on : Mar 8, 2019, 5:03:39 PM
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
		<tr>
			<td>喜好:<br> <textarea rows="8" cols="40" name="favor"
					style="background-color: D7F8AB"/>
			</td>
		</tr>
		<tr>
			<td align="center"><input type="submit" value="上一步"
				name="_target2" /> <input type="submit" value="完成" name="_finish" />
				<input type="submit" value="取消" name="_cancel" /></td>
		</tr>
	</form>
</body>
</html>
