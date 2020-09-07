<%-- 
    Document   : pagination
    Created on : 2019-4-24, 16:08:32
    Author     : root
--%>

<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js">
</script>
</head>
<body>-->
<c:import url="header.jsp">
    <c:param name="title" value="login"/>
    <%--<c:param name="locale" value="zh_CN"/>--%>
    <c:param name="h3" value="Artice deatils"/>
    <c:param name="locale" value="${language}"/>
    <%--<c:param name="locale" value="en_US"/>--%>
</c:import>
<h1></h1><h1></h1>
	<table border="1" align="center" width="800">
		<tr class="trhead" id="show_tab_one">
			<th>Author</th>
			<th>Title</th>
                        <th>Content</th>
                        <th width="100">Action</th>
		</tr>
		<c:forEach items="${requestScope.pb.list}" var="li">
			<tr>
				<th align="center">${li.user.userName}</th>
				<th align="center">${li.title}</th>
                                <th align="center">${li.content}</th>
                                <th align="center">
                                    <!--<div class="alert alert-info" role="alert">-->
                                <a href='viewArticle.htm?articleId=${li.articleId}&articleAction=details'>View Article</a>
                                    <!--</div>-->
                                </th>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="${pageContext.request.contextPath}/navigation.htm?navigation=pagination&pageNum=1">First | </a>
	<c:if test="${requestScope.pb.pageNum ==1}">
            <c:forEach begin="${requestScope.pb.start}" end="${requestScope.pb.end}" step="1" var="i">
                <c:if test="${requestScope.pb.pageNum != i}">
                    <a href="${pageContext.request.contextPath}/navigation.htm?navigation=pagination&pageNum=${i}">${i}</a>
                </c:if>
            </c:forEach>
		<a href="${pageContext.request.contextPath}/navigation.htm?navigation=pagination&pageNum=${requestScope.pb.pageNum+1}">Next |</a>
	</c:if>
	<c:if test="${requestScope.pb.pageNum > 1 && requestScope.pb.pageNum < requestScope.pb.totalPage}">
            <a href="${pageContext.request.contextPath}/navigation.htm?navigation=pagination&pageNum=${requestScope.pb.pageNum-1}">Previous | </a>
            <a href="${pageContext.request.contextPath}/navigation.htm?navigation=pagination&pageNum=${requestScope.pb.pageNum+1}">Next |</a>
	</c:if>
	<c:if test="${requestScope.pb.pageNum == requestScope.pb.totalPage}">
            <a href="${pageContext.request.contextPath}/navigation.htm?navigation=pagination&pageNum=${requestScope.pb.pageNum-1}">Previous |</a>
	</c:if>
	<a href="${pageContext.request.contextPath}/navigation.htm?navigation=pagination&pageNum=${requestScope.pb.totalPage}">Last</a>
<br/><br/><br/><br/><br/>
</body>
<c:import url="footer.jsp"/>
</html>


