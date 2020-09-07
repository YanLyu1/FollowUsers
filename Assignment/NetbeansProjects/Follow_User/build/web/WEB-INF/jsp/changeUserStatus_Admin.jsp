<%-- 
    Document   : changeUserStatus_Admin
    Created on : Apr 11, 2019, 4:16:13 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change User Status</title>
    </head>
    <body>-->
<c:import url="header.jsp">
        <c:param name="title" value="register"/>
        <%--<c:param name="locale" value="zh_CN"/>--%>
        <c:param name="h3" value="chaneg status"/>
        <c:param name="locale" value="${language}"/>
        <%--<c:param name="locale" value="en_US"/>--%>
    </c:import>
        <script language="javascript">
            function sumbit_form(){
                var gnl=confirm("Please Confirm To Change User Status?");
                if (gnl==true){
                    return true;
                }else{
                    return false;
                }
            }
        </script>
        
        <h1></h1>
        <form action="changeStatus.htm" method="get">
            <table border="1" align="center" width="800">
                <th align="center">User ID</th>
                <th align="center">User Name</th>
                <th align="center">Status</th>
                <th align="center">drop</th>
                <th align="center">resume</th>
                <c:forEach var="user" items="${userList}">
                <tr align="center">
                    <td align="center">${user.userId}</td>
                    <td align="center">${user.userName}</td>
                    <td align="center">${user.status}</td>
                        <td align="center">
                            <a href="changeStatus.htm?userId=${user.userId}&changeStatus=drop" onclick="return sumbit_form()">drop</a></td>
                        <td><a href="changeStatus.htm?userId=${user.userId}&changeStatus=resume" onclick="return sumbit_form()">resume</a></td>
                </tr>
                </c:forEach>
            </table>
        </form>
        <br/><br/><br/><br/><br/>
    </body>
    <c:import url="footer.jsp"/>
</html>
